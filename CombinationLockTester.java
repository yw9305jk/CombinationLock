/*	Kou Vang
 *  ICS 240.01
 *  Metrostate University
 *  Assignment 1 - Combination Lock
 */


import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CombinationLockTester implements ActionListener
{
	CombinationLock test = new CombinationLock(0, 0, 0);
	Font myFont = new Font("Serif", Font.BOLD, 100);
	JPanel titlePanel, scorePanel, buttonPanel;
    JLabel lockCombinationLabel, lockStatusLabel, lockCurrentCombinationLabel, lockCombinationCount, lockCombinationCurrentCount, topCount, lockCombinationStatus, revolutionLabel, revolutionStatus, directionStatus;
    JButton counterClockwiseButton, clockwiseButton, resetButton, closeButton, openButton, newCombinationButton, saveButton;
	
	public JPanel createContentPane (){

        // We create a bottom JPanel to place everything on.
        JPanel totalGUI = new JPanel();
        totalGUI.setLayout(null);

        // Creation of a Panel to contain the title labels
        titlePanel = new JPanel();
        titlePanel.setLayout(null);
        titlePanel.setLocation(10, 0);
        titlePanel.setSize(500, 30);
        totalGUI.add(titlePanel);

        lockCombinationLabel = new JLabel("Lock Combination");
        lockCombinationLabel.setLocation(0, 0);
        lockCombinationLabel.setSize(200, 30);
        lockCombinationLabel.setHorizontalAlignment(0);
        lockCombinationLabel.setForeground(Color.red);
        titlePanel.add(lockCombinationLabel);
        
        revolutionLabel = new JLabel("One Revolution");
        revolutionLabel.setLocation(0, 50);
        revolutionLabel.setSize(200, 30);
        revolutionLabel.setHorizontalAlignment(0);
        revolutionLabel.setForeground(Color.black);
        titlePanel.add(revolutionLabel);
        
        lockStatusLabel = new JLabel("Lock Status");
        lockStatusLabel.setLocation(125, 0);
        lockStatusLabel.setSize(200, 30);
        lockStatusLabel.setHorizontalAlignment(0);
        lockStatusLabel.setForeground(Color.black);
        titlePanel.add(lockStatusLabel);

        lockCurrentCombinationLabel = new JLabel("Current Combination");
        lockCurrentCombinationLabel.setLocation(250, 0);
        lockCurrentCombinationLabel.setSize(200, 30);
        lockCurrentCombinationLabel.setHorizontalAlignment(0);
        lockCurrentCombinationLabel.setForeground(Color.blue);
        titlePanel.add(lockCurrentCombinationLabel);
        
        lockCurrentCombinationLabel = new JLabel();
        lockCurrentCombinationLabel.setLocation(250, 50);
        lockCurrentCombinationLabel.setSize(200, 30);
        lockCurrentCombinationLabel.setHorizontalAlignment(0);
        lockCurrentCombinationLabel.setForeground(Color.blue);
        titlePanel.add(lockCurrentCombinationLabel);

        // Creation of a Panel to contain the score labels.
        scorePanel = new JPanel();
        scorePanel.setLayout(null);
        scorePanel.setLocation(10, 25);
        scorePanel.setSize(500, 175);
        totalGUI.add(scorePanel);

        lockCombinationCount = new JLabel(test.getX() + ", " + test.getY() + ", " + test.getZ());
        lockCombinationCount.setLocation(0, 0);
        lockCombinationCount.setSize(200, 20);
        lockCombinationCount.setHorizontalAlignment(0);
        scorePanel.add(lockCombinationCount);
        
        revolutionStatus = new JLabel("One Revolution: " + test.isOneRevolution());
        revolutionStatus.setLocation(0, 110);
        revolutionStatus.setSize(200, 20);
        revolutionStatus.setHorizontalAlignment(0);
        scorePanel.add(revolutionStatus);
        
        lockCombinationStatus = new JLabel("" + test.getLockStatus());
        lockCombinationStatus.setLocation(125, 0);
        lockCombinationStatus.setSize(200, 20);
        lockCombinationStatus.setHorizontalAlignment(0);
        scorePanel.add(lockCombinationStatus);

        lockCombinationCurrentCount = new JLabel(test.getA() + ", " + test.getB() + ", " + test.getC());
        lockCombinationCurrentCount.setLocation(250, 0);
        lockCombinationCurrentCount.setSize(200, 20);
        lockCombinationCurrentCount.setHorizontalAlignment(0);
        scorePanel.add(lockCombinationCurrentCount);
        
        directionStatus = new JLabel("Clockwise: " + test.isClockwise());
        directionStatus.setLocation(250, 110);
        directionStatus.setSize(200, 20);
        directionStatus.setHorizontalAlignment(0);
        scorePanel.add(directionStatus);
        
        topCount = new JLabel("" + test.getTopNumber());
        topCount.setFont(myFont);
        topCount.setLocation(125, 40);
        topCount.setSize(200, 100);
        topCount.setHorizontalAlignment(0);
        scorePanel.add(topCount);
        

        // Creation of a label to contain all the JButtons.
        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setLocation(10, 80);
        buttonPanel.setSize(500, 400);
        totalGUI.add(buttonPanel);

        counterClockwiseButton = new JButton("<-- Counter-Clockwise");
        counterClockwiseButton.setLocation(0, 160);
        counterClockwiseButton.setSize(175, 30);
        counterClockwiseButton.addActionListener(this);
        buttonPanel.add(counterClockwiseButton);

        clockwiseButton = new JButton("Clockwise -->");
        clockwiseButton.setLocation(275, 160);
        clockwiseButton.setSize(175, 30);
        clockwiseButton.addActionListener(this);
        buttonPanel.add(clockwiseButton);

        closeButton = new JButton("Close");
        closeButton.setLocation(0, 120);
        closeButton.setSize(175, 30);
        closeButton.addActionListener(this);
        buttonPanel.add(closeButton);
        
        saveButton = new JButton("Save #");
        saveButton.setLocation(185, 120);
        saveButton.setSize(80, 70);
        saveButton.addActionListener(this);
        buttonPanel.add(saveButton);
        
        openButton = new JButton("Open");
        openButton.setLocation(275, 120);
        openButton.setSize(175, 30);
        openButton.addActionListener(this);
        buttonPanel.add(openButton);

        resetButton = new JButton("Reset Lock");
        resetButton.setLocation(0, 200);
        resetButton.setSize(450, 30);
        resetButton.addActionListener(this);
        buttonPanel.add(resetButton); 
        
        newCombinationButton = new JButton("Get New Combination");
        newCombinationButton.setLocation(0, 240);
        newCombinationButton.setSize(450, 30);
        newCombinationButton.addActionListener(this);
        buttonPanel.add(newCombinationButton); 
        
        totalGUI.setOpaque(true);
        return totalGUI;
    }
	
	  // This is the new ActionPerformed Method.
    // It catches any events with an ActionListener attached.
    // Using an if statement, we can determine which button was pressed
    // and change the appropriate values in our GUI.
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == counterClockwiseButton)
        {
            test.turnKnobCounterClockwise();
            topCount.setText("" + test.getTopNumber());
            lockCombinationCurrentCount.setText(test.getA() + ", " + test.getB() + ", " + test.getC());
            revolutionStatus.setText("One Revolution: " + test.isOneRevolution());
            directionStatus.setText("Clockwise: " + test.isClockwise());
 
        }
        else if(e.getSource() == clockwiseButton)
        {
        	test.turnKnobClockwise();
            topCount.setText("" + test.getTopNumber());
            lockCombinationCurrentCount.setText(test.getA() + ", " + test.getB() + ", " + test.getC());
            revolutionStatus.setText("One Revolution: " + test.isOneRevolution());
            directionStatus.setText("Clockwise: " + test.isClockwise());
        }
        else if(e.getSource() == closeButton)
        {
        	test.closeLock();
        	lockCombinationStatus.setText("" + test.getLockStatus());

        }
        else if(e.getSource() == openButton)
        {
        	test.openLock();
        	lockCombinationStatus.setText("" + test.getLockStatus());
        }
        else if(e.getSource() == resetButton)
        {
            test.resetLock();
            topCount.setText("" + test.getTopNumber());
            lockCombinationCurrentCount.setText(test.getA() + ", " + test.getB() + ", " + test.getC());
            revolutionStatus.setText("One Revolution: " + test.isOneRevolution());
            directionStatus.setText("Clockwise: " + test.isClockwise());
        }
        
        else if(e.getSource() == newCombinationButton)
        {
            test.alterLockCombination();
            topCount.setText("" + test.getTopNumber());
            lockCombinationCount.setText(test.getX() + ", " + test.getY() + ", " + test.getZ());
            revolutionStatus.setText("One Revolution: " + test.isOneRevolution());
            directionStatus.setText("Clockwise: " + test.isClockwise());
        }
        
        else if(e.getSource() == saveButton)
        {
            test.saveNumber();
            topCount.setText("" + test.getTopNumber());
            lockCombinationCurrentCount.setText(test.getA() + ", " + test.getB() + ", " + test.getC());
            revolutionStatus.setText("One Revolution: " + test.isOneRevolution());
            directionStatus.setText("Clockwise: " + test.isClockwise());
        }
    }

    private static void createAndShowGUI() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Combination Lock Tester");

        //Create and set up the content pane.
        CombinationLockTester demo = new CombinationLockTester();
        frame.setContentPane(demo.createContentPane());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 400);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    } 
}

