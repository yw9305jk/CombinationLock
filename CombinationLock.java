/*	Kou Vang
 *  ICS 240.01
 *  Metrostate University
 *  Assignment 1 - Combination Lock
 */

import java.util.*;

public class CombinationLock 
{

		private int top = 0;						// The topmost number in the combination lock
		private int x = 0;							// First number in the combination lock
		private int y = 0;							// Second number in the combination lock
		private int z = 0;							// Third number in the combination lock
		private int a = 0;							// Your first number entry
		private int b = 0;							// Your second entry number
		private int c = 0;							// Your third entry number
		private int clickCounter = 0;				// Number of clicks (40) to count as a revolution
		boolean lockOpened = false;					// Status of the lock
		boolean revolutionCounter = false;			// Whether or not the lock has made a full revolution
		boolean clockwise = false;					// Whether or not the lock is being turned clockwise
		boolean firstInput = false;					// Whether or not the first input has been entered
		boolean secondInput = false;				// Whether or not the second input has been entered
		boolean thirdInput = false;					// Whether or not the third input has been entered
		
			
	public CombinationLock(int x, int y, int z)		// Constructor
	{
		
	}
	
	public void alterLockCombination()				// Method to alter the lock combination
	{	
		a = 0;
		b = 0;
		c = 0;
		top = 0;
		revolutionCounter = false;
		clickCounter = 0;
		firstInput = false;
		secondInput = false;
		thirdInput = false;
		clockwise = false;
		Random generator = new Random(); 			// Randomly generate numbers 0-39 
		x = generator.nextInt(39);
		y = generator.nextInt(39);
		z = generator.nextInt(39);
		
	}
	
	public void turnKnobClockwise()					// Method to turn the knob clockwise
	{
		clockwise = true;							// Set the clockwise position to true since we're turning it clockwise
		clickCounter = clickCounter + 1;			// Adjust the click counter
		
		if (clickCounter == 40)						// After one full rotation, set revolution counter to true since it has made a full rotation
		{
			revolutionCounter = true;
			clickCounter = 0;						// Reset the click counter
		}
			
		top = top + 1;								// Increase the top counter
		if (top > 39)
		{
			top = 0;								// If top counter surpasses 39, reset it to 0 since the lock knob only goes up to 39
		}
		
	}
	
	public void turnKnobCounterClockwise()			// Method to turn the knob counter-clockwise
	{
		clockwise = false;							// Since the knob is being turned counter-clockwise, set clockwise rotation to false
		clickCounter = clickCounter - 1;			// Subtract the click counter by 1 since we are moving down the number chain
		
		if (clickCounter == -40)					// To keep track of counter-clockwise revolutions, once it has made 40 clicks reset click counter
		{
			clickCounter = 0;						
		}
			
		top = top - 1;								// Moving clockwise will make the counter go down (39...38...37.. etc...)
		if (top < 0)
		{
			top = 39;								// Once we reach zero, we reset it to 39 to decrease the counter
		}
		
		if (revolutionCounter == true)				// If changing direction, reset revolution counter
		{
			revolutionCounter = false;
		}
		
	}
	
	public void saveNumber()						// Method to save the numbers
	{
		if (revolutionCounter == true && clockwise == true && firstInput == false)
		{
			firstInput = true;
			a = top;
		}
		
		if (firstInput == true && clockwise == false && secondInput == false)
		{
			secondInput = true;
			b = top;
		}
		
		if (secondInput == true && clockwise == true && thirdInput == false)
		{
			thirdInput = true;
			c = top;
		}
	}
	
	public void closeLock()							// Method to lock the combination locker
	{
		lockOpened = false;;
	}
	
	public void resetLock()							// Method to reset the lock
	{
		a = 0;
		b = 0;
		c = 0;
		x = 0;
		y = 0;
		z = 0;
		top = 0;
		revolutionCounter = false;
		clickCounter = 0;
		firstInput = false;
		secondInput = false;
		thirdInput = false;
		clockwise = false;
		

	}
	
	public void openLock()							// Method to open the lock
	{
		if (a == x && b == y && c == z)
		{
			lockOpened = true;
		}
		else
		{
			lockOpened = false;
		}
	}
	
	public boolean isOneRevolution()				// Method to check if the user has made one revolution
	{
		return revolutionCounter;
	}
	
	public boolean isClockwise()					// Method to see if the knob is being turned clockwise
	{
		return clockwise;
	}
	
	public String getLockStatus()					// Method to check the lock status
	{
		String lockStatus;
		
		if (lockOpened == false)
		{
			lockStatus = "Closed";
		}
		else 
		{
			lockStatus = "Opened";
		}
		
		return lockStatus;
	}
	
	public int getTopNumber()						// Method to get the top number
	{
		return top;
	}
	
	public int getX()								// Method to get the combination numbers
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getZ()
	{
		return z;
	}
	
	public int getA()
	{
		return a;
	}
	
	public int getB()
	{
		return b;
	}
	
	public int getC()
	{
		return c;
	}
}
