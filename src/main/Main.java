package main;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import menus.MainMenu;
import menus.RollMenu;

public class Main extends Canvas implements Runnable, MouseListener{
	
	private Thread thread;

	public static JFrame frame;
	private static final long serialVersionUID = 1L;
	public static boolean isRunning;
	
	public static int WIDTH = 350;
	public static int HEIGHT = 500; 
	public static int SCALE = 1;
	
	private BufferedImage image;
	private static MainMenu mainMenu;
	private static RollMenu rollMenu;
	public static String appState;
	
	public static void main(String[] args) {
		Main main = new Main();
		main.start();
	}
	
	public Main() {
		appState = "MainMenu";
		addMouseListener(this);
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		initFrame();
		image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		mainMenu = new MainMenu();
		rollMenu = new RollMenu();
	}
	
	public void initFrame() {
		frame = new JFrame("Dice Roller");
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
		
	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}
	
	public void tick() {
		if(appState.equals("MainMenu")) {
			mainMenu.tick();
		}
		else if(appState.equals("RollMenu")) {
			rollMenu.tick();
		}
	}
		
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(new Color(10,10,10));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);
		if(appState == "MainMenu")
			mainMenu.render(g);
		else if(appState == "RollMenu")
			rollMenu.render(g);
		bs.show();
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amoutOfTicks = 60.0;
		double ns = 1000000000 / amoutOfTicks;
		double delta = 0;
		double timer = System.currentTimeMillis();
		int frames = 0;
		while(isRunning) {
			long now = System.nanoTime();
			delta+= (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1) {
				tick();
				render();
				frames++;
				delta--;
			}
			if(System.currentTimeMillis() - timer >= 1000) {
				System.out.println("FPS: " + frames);
				frames = 0;
				timer+=1000;
			}
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(appState.equals("MainMenu")) {
			mainMenu.mouseClicked = true;
			mainMenu.mx = MouseInfo.getPointerInfo().getLocation().x - this.getLocationOnScreen().x;
			mainMenu.my = MouseInfo.getPointerInfo().getLocation().y - this.getLocationOnScreen().y;
		}
		if(appState.equals("RollMenu")) {
			rollMenu.mouseClicked = true;
			rollMenu.mx = MouseInfo.getPointerInfo().getLocation().x - this.getLocationOnScreen().x;
			rollMenu.my = MouseInfo.getPointerInfo().getLocation().y - this.getLocationOnScreen().y;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}
	
}


			
		
		
	

