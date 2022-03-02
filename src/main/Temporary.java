package main;

import java.util.Scanner;

public class Temporary {

	public static double odd;
	public static int roll, diceAmount, rollTotal, customDice;
	public static String goAgain, diceSelected, answer;
	public static boolean diceRolled = false, rollNow = false, alreadyRolled = false;
	public static Scanner in = new Scanner(System.in);
	
	public static void nowRolling() {
		rollNow = true;
		if(rollNow) {
			System.out.println("Quantos dados gostaria de rolar? digite apenas o número e aperte |ENTER|");
			diceAmount = in.nextInt();
			in.nextLine();
			System.out.println("Qual dado gostaria de rolar? Aperte |ENTER| ao digitar.");
			System.out.println("D4 | D6 | D8 | D10 | D12 | D20 | D100 | DCUSTOM");
			diceSelected = in.nextLine();
			rollNow = false;
			
		if(diceSelected.equals("D4") || diceSelected.equals("D6") || diceSelected.equals("D8") || diceSelected.equals("D10") 
				|| diceSelected.equals("D12") || diceSelected.equals("D20") || diceSelected.equals("D100") || diceSelected.equals("DCUSTOM") ) {
			
		while(diceAmount > 0) {
			switch(diceSelected) {
				case "D4":
					
					odd = Math.random();
					roll = (int)((odd * 100) / 25) + 1;
					System.out.println("Sua rolagem deu: " + roll);
					diceRolled = true;
					break;
				case "D6":
					
					odd = Math.random();
					roll = (int)((odd * 100) / 15) + 1;
					System.out.println("Sua rolagem deu: " + roll);
					diceRolled = true;
					break;
				case "D8":
					
					odd = Math.random();
					roll = (int)((odd * 100) / 12.5) + 1;
					System.out.println("Sua rolagem deu: " + roll);
					diceRolled = true;
					break;
				case "D10":
					
					odd = Math.random();
					roll = (int)((odd * 100) / 10) + 1;
					System.out.println("Sua rolagem deu: " + roll);
					diceRolled = true;
					break;
				case "D12":
					
					odd = Math.random();
					roll = (int)((odd * 100) / 8.333) + 1;
					System.out.println("Sua rolagem deu: " + roll);
					diceRolled = true;
					break;
				case "D20":
					odd = Math.random();
					roll = (int)((odd * 100) / 5) + 1;
					System.out.println("Sua rolagem deu: " + roll);
					diceRolled = true;
					break;
				case "D100":
					odd = Math.random();
					roll = (int)(odd * 100) + 1;
					System.out.println("Sua rolagem deu: " + roll);
					diceRolled = true;
					break;	
				case "DCUSTOM":
					if(!alreadyRolled) {
						System.out.println("Digite quantos lados tem o seu dado (Apenas números)");
						customDice = in.nextInt();
						in.nextLine();
						System.out.println("Seu dado tem |" + customDice + "| lados. Está correto?");
						System.out.println("Sim | Não");
						answer = in.nextLine();
						alreadyRolled = true;
					}
					if(answer.equals("Sim") || answer.equals("sim") || answer.equals("SIM") ) {
						odd = Math.random();
						roll = (int)((odd * 100) / (100 / customDice)) + 1; 
						System.out.println("Sua rolagem deu: " + roll);
						diceRolled = true;
						break;
					}else {
						customDice = 0;
						diceAmount = 0;
						alreadyRolled = false;
						nowRolling();
					}
				}
			diceAmount--;
			rollTotal += roll;
		}
		}else {
			diceSelected.equals("");
			System.out.println("O valor digitado não é valido, tente novamente.");
			nowRolling();
		}
		
		if(diceAmount <= 0) {
			System.out.println("O valor total da jogada deu: " + rollTotal);
			rollTotal = 0;
			rollAgain();
		}
		}
	}
		
		public static void rollAgain() {
			if(diceRolled = true) {
				rollTotal = 0;
				customDice = 0;
				diceRolled = false;
				alreadyRolled = false;
				answer = "";
				System.out.println("Gostaria de rolar mais dados?");
				goAgain = in.nextLine();
				if(goAgain.equals("Sim") || goAgain.equals("SIM") || goAgain.equals("sim")) {
					nowRolling();
				}else
					System.out.println("Ok, fechando programa.");
					System.exit(1);
			}
			
		}
	
}
