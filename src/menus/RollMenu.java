package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import main.DiceLogic;
import main.Main;

public class RollMenu {
	
	public int mx, my;
	public boolean mouseClicked = false;
	
	private int b1X = 45, b1Y = 200, b1W = 80, b1H = 70;
	private int b2X = 135, b2Y = 200, b2W = 80, b2H = 70;
	private int b3X = 225, b3Y = 200, b3W = 80, b3H = 70;
	private int b4X = 45, b4Y = 280, b4W = 80, b4H = 70;
	private int b5X = 135, b5Y = 280, b5W = 80, b5H = 70;
	private int b6X = 225, b6Y = 280, b6W = 80, b6H = 70;
	private int b7X = 45, b7Y = 360, b7W = 80, b7H = 70;
	private int b8X = 135, b8Y = 360, b8W = 80, b8H = 70;
	private int b9X = 225, b9Y = 360, b9W = 80, b9H = 70;
	
	public Color square = new Color(245,245,245);
	public Color words = new Color(15,15,15);
	public Color fundo = new Color(199,129,54);

	public void tick() {
		if(mouseClicked) {
			mouseClicked = false;
			//System.out.println("x " + mx);
			//System.out.println("y " + my);
			
			//d4 button bounds
			if(mx > b1X && mx < (b1X + b1W)) {
				if(my > b1Y && my < (b1Y + b1H)) {
					//action
					DiceLogic.d4Amount++;
					DiceLogic.nowRolling();
				}
			}
			//d6 button bounds
			if(mx > b2X && mx < (b2X + b2W)) {
				if(my > b2Y && my < (b2Y + b2H)) {
					//action
					DiceLogic.d6Amount++;
					DiceLogic.nowRolling();
				}
			}
			//d8 button bounds
			if(mx > b3X && mx < (b3X + b3W)) {
				if(my > b3Y && my < (b3Y + b3H)) {
					//action
					DiceLogic.d8Amount++;
					DiceLogic.nowRolling();
				}
			}
			//d10 button bounds
			if(mx > b4X && mx < (b4X + b4W)) {
				if(my > b4Y && my < (b4Y + b4H)) {
					//action
					DiceLogic.d10Amount++;
					DiceLogic.nowRolling();
				}
			}
			//d12 button bounds
			if(mx > b5X && mx < (b5X + b5W)) {
				if(my > b5Y && my < (b5Y + b5H)) {
					//action
					DiceLogic.d12Amount++;
					DiceLogic.nowRolling();
				}
			}
			//d20 button bounds
			if(mx > b6X && mx < (b6X + b6W)) {
				if(my > b6Y && my < (b6Y + b6H)) {
					//action
					DiceLogic.d20Amount++;
					DiceLogic.nowRolling();
				}
			}
			//d100 button bounds
			if(mx > b8X && mx < (b8X + b8W)) {
				if(my > b8Y && my < (b8Y + b8H)) {
					//action
					DiceLogic.d100Amount++;
					DiceLogic.nowRolling();
				}
			}
			//Erase button bounds
			if(mx > b9X && mx < (b9X + b9W)) {
				if(my > b9Y && my < (b9Y + b9H)) {
					//action
					DiceLogic.zeroing();
					DiceLogic.roll = 0;
					DiceLogic.rollTotal = 0;
				}
			}
			//Return button bounds
			if(mx > b7X && mx < (b7X + b7W)){
				if(my > b7Y && my < (b7Y + b7H))
				Main.appState = "MainMenu";
			}
		}
		square=new Color(245, 245, 245);
	}
	
	public void render(Graphics g) {
			//System.out.println("Roll Menu");
			
			//fundo e titulo
			g.setColor(fundo);
			g.fillRect(0, 0, Main.WIDTH*Main.SCALE, Main.HEIGHT*Main.SCALE);
			g.setColor(new Color(240,190,100));
			g.fillRect(30, 78, 300, 110);
			g.setColor(words);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("Escolha os dados que quer rolar.", 20, 50);
			g.setFont(new Font("Arial", Font.BOLD, 15));
			g.drawString("Clique quantas vezes quiser que cada um role.", 13, 70);
			
			//mostrador de dados

			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.setColor(words);
			g.drawString("Atual", 70, 105);
			g.drawString("Total", 240, 105);
			
			g.setFont(new Font("Arial", Font.BOLD, 45));
			
			int x1;
			int x2;
			if(DiceLogic.rollTotal >=10) {
				x2 = 240;
				if(DiceLogic.rollTotal>=100)
					x2=225;
			}else
				x2 = 255;
			if(DiceLogic.roll>=10)
					x1 = 70;
			else
					x1 = 85;
			g.drawString("" + DiceLogic.rollTotal, x2, 160);
			g.drawString("" + DiceLogic.roll, x1, 160);
			
			//botões
			g.setColor(square);
			//d4
			g.fillRect(b1X, b1Y, b1W, b1H);
			//d6
			g.fillRect(b2X, b2Y, b2W, b2H);
			//d8
			g.fillRect(b3X, b3Y, b3W, b3H);
			//d10
			g.fillRect(b4X, b4Y, b4W, b4H);
			//d12
			g.fillRect(b5X, b5Y, b5W, b5H);
			//d20
			g.fillRect(b6X, b6Y, b6W, b6H);
			//voltar
			g.fillRect(b7X, b7Y, b7W, b7H);
			//d100
			g.fillRect(b8X, b8Y, b8W, b8H);
			//dCustom
			g.fillRect(b9X, b9Y, b9W, b9H);
			
			//palavras nos botões
			g.setColor(words);
			g.setFont(new Font("Arial", Font.BOLD, 40));
			g.drawString("D4", 60, 250);
			g.drawString("D6", 150, 250);
			g.drawString("D8", 240, 250);
			g.drawString("D10", 50, 330);
			g.drawString("D12", 140, 330);
			g.drawString("D20", 230, 330);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString("D100", 139, 405);
			g.setFont(new Font("Arial", Font.BOLD, 25));
			g.drawString("Voltar", 49, 405);
			g.setFont(new Font("Arial", Font.BOLD, 24));
			g.drawString("Limpar", 224, 404);
			
	}	
}
