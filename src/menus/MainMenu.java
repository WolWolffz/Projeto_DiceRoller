package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import main.DiceLogic;
import main.Main;

public class MainMenu{
	
	public int mx, my;
	public boolean mouseClicked;
	
	private int b1X = 100, b1Y = 150, b1W = 150, b1H = 50;
	private int b2X = 100, b2Y = 210, b2W = 150, b2H = 50;
	//private int b3X = 100, b3Y = 270, b3W = 150, b3H = 50;
	
	public void tick() {
		
		DiceLogic.roll = 0;
		DiceLogic.rollTotal = 0;
		
		if(mouseClicked) {
			mouseClicked = false;
			//System.out.println("x " + mx);
			//System.out.println("y " + my);
			
			//botão Rolar
			if(mx > b1X && mx < (b1X + b1W)) {
				if(my > b1Y && my < (b1Y + b1H)) {
					Main.appState = "RollMenu";
				}
			}
			
			//botão Config
			/*
			if(mx > b2X && mx < (b2X + b2W)) {
				if(my > b2Y && my < (b2Y + b2H)) {
					System.out.println("botão 2 foi apertado");
				}
			}
			*/
			//botão Sair
			if(mx > b2X && mx < (b2X + b2W)) {
				if(my > b2Y && my < (b2Y + b2H)) {
					System.exit(1);
				}
			}
		}
		
	}
	
	public void render(Graphics g) {
		//System.out.println("Main Menu");
		Color square = new Color(240,240,240);
		Color words = new Color(15,15,15);
		Color fundo = new Color(199,129,54);
		
		//fundo e titulo
		g.setColor(fundo);
		g.fillRect(0, 0, Main.WIDTH*Main.SCALE, Main.HEIGHT*Main.SCALE);
		g.setColor(words);
		g.setFont(new Font("Arial", Font.BOLD, 28));
		g.drawString("Dice Roller",Main.WIDTH*Main.SCALE/2 - 70,Main.HEIGHT/8 - 1);
		
		//botões
		g.setColor(square);
		g.fillRect(b1X, b1Y, b1W, b1H);
		g.fillRect(b2X, b2Y, b2W, b2H);
		//g.fillRect(100, 270, 150,50);
		
		//palavras nos botões
		g.setColor(words);
		g.setFont(new Font("Arial",Font.BOLD, 25));
		g.drawString("Rolar Dados", 101, 185);
		//g.drawString("Config", 135, 245);
		g.drawString("Sair", 150, 245);
	}

}
