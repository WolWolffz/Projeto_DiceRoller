package main;

import java.util.Random;

public class DiceLogic {

	public static int d4Amount = 0;
	public static int d6Amount = 0;
	public static int d8Amount = 0;
	public static int d10Amount = 0;
	public static int d12Amount = 0;
	public static int d20Amount = 0;
	public static int d100Amount = 0;
	public static int dCustomAmount = 0;
	
	public static int roll, diceAmount, rollTotal, customDice;
	public static String goAgain, diceSelected, answer;
	public static boolean diceRolled = false, rollNow = false, alreadyRolled = false;
	
	public static void nowRolling() {
		rollNow = true;
		if(rollNow) {
			for(int i = d4Amount; i > 0; i--) {
				roll = new Random().nextInt(4)+1;
				System.out.println("D4: " + roll);
				diceRolled = true;
				rollTotal += roll;
			}
			for(int i = d6Amount; i > 0; i--) {
				roll = new Random().nextInt(6)+1;
				System.out.println("D6: " + roll);
				diceRolled = true;
				rollTotal += roll;
			}
			for(int i = d8Amount; i > 0; i--) {
				roll = new Random().nextInt(8)+1;
				System.out.println("D8: " + roll);
				diceRolled = true;
				rollTotal += roll;
			}
			for(int i = d10Amount; i > 0; i--) {
				roll = new Random().nextInt(10)+1;
				System.out.println("D10: " + roll);
				diceRolled = true;
				rollTotal += roll;
			}
			for(int i = d12Amount; i > 0; i--) {
				roll = new Random().nextInt(12)+1;
				System.out.println("D12: " + roll);
				diceRolled = true;
				rollTotal += roll;
			}
			for(int i = d20Amount; i > 0; i--) {
				roll = new Random().nextInt(20)+1;
				System.out.println("D20: " + roll);
				diceRolled = true;
				rollTotal += roll;
			}
			for(int i = d100Amount; i > 0; i--) {
				roll = new Random().nextInt(100)+1;
				System.out.println("D100: " + roll);
				diceRolled = true;
				rollTotal += roll;
			}
			
		}
		System.out.println("O valor total da jogada deu: " + rollTotal);
		zeroing();
	}
	
	public static void zeroing() {
		System.out.println("Zeroing on");
		d4Amount = 0;
		d6Amount = 0;
		d8Amount = 0;
		d10Amount = 0;
		d12Amount = 0;
		d20Amount = 0;
		d100Amount = 0;
		dCustomAmount = 0;
	}
	
}
