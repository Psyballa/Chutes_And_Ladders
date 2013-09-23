import java.util.Random;

/**
 * 
 */

/**
 * @author Psy
 * 
 */
public class Dice {
	int roll;
	Random diceRoller;
	
	public Dice(int roll, Random diceRoller){
		this.roll = roll;
		this.diceRoller = diceRoller;
	}
	
	public int setRoll(){
		roll = Math.abs((diceRoller.nextInt(65536) - 32768)) % 6;
		if(roll == 0){
			roll = 1;
		}
		return this.roll;
	}
	
	/* DEBUG SETROLL FOR LADDER TESTING */
	public int setRoll(int i){
		this.roll = i;
		return this.roll;
	}
	
	public int getRoll(){
		return this.roll;
	}
}
