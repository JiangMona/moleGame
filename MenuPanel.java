/*
Name: Mona Jiang and Catharine Zhou
Class: ICS3U7-1
Teacher: Ms. Strelkovska
Assignment: Final Project
Description: Main menu panel for Kirby Adventures game
*/

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
public class MenuPanel extends JPanel implements ActionListener{

	private JButton game;//instructions
	private JButton instructions;//level
	private JButton highScore;
	private JButton exit;//exit
	private ImageIcon back;
	private JLabel bg;
	private static ImageIcon startGame, highS, instruct, leave, inst;
	private Font pixelFont;
	public MenuPanel() {
		
		this.setLayout(null);//not using premade layout
		
		startGame = new ImageIcon("startGame.png");
		game = new JButton(startGame);//start from levl 1
		makeClearButton(game);
	    instruct = new ImageIcon("instructions.png");
		instructions = new JButton(instruct); 
		makeClearButton(instructions);
	    
	    highS= new ImageIcon("highScore.png");
		highScore = new JButton(highS); 
		makeClearButton(highScore);
		
		leave= new ImageIcon("exit.png");
		exit = new JButton(leave); 
		makeClearButton(exit);

		//b1.setLocation(30, 200);
		//b1.setSize(200, 30);
		game.setBounds(75, 200, 200, 30); //same thing as set location and set size
		//this.add(game);//use _this_ to refer to the main panel itself
		instructions.setBounds(300, 200, 250, 30); 
		//this.add(instructions);
		highScore.setBounds(75, 300, 200, 30); 
		//this.add(highScore);
		exit.setBounds(325, 300, 200, 35); 
		//this.add(exit);
		
		//ADDED ACTION LISTENER IN METHOD
		back = new ImageIcon("background.gif");
		inst = new ImageIcon("inst.png");
		bg= new JLabel(back);
		bg.setBounds(0,0, 600, 600);
		add(bg);
		
		// import custom pixel font
		try {
			pixelFont = Font.createFont(Font.TRUETYPE_FONT, new File("PixelFont.ttf")).deriveFont(12f);
		    GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    g.registerFont(pixelFont);
		} 
		catch (IOException e) {
		    e.printStackTrace();
		} 
		catch(FontFormatException e) {
		    e.printStackTrace();
		}
		
		UIManager.put("OptionPane.messageFont", pixelFont);
		UIManager.put("OptionPane.buttonFont", pixelFont);
		
	}
	public void paintComponent(Graphics g) {//no double buffering --> double buffering: java creates off screen image and replaces entire screen
		super.paintComponent(g);
		g.setFont(new Font("SansSerif", Font.ITALIC, 30));
		g.drawString("KIRBY ADVENTURES", 150, 150);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==game) {
			//go to game
			//MainP.cardsL.next(MainP.cont); //go to frame, go through layout, get next panel
			//MainP.menuP.setFocusable(false);
			//MainP.gameP.setFocusable(true);
			//MainP.gameP.requestFocus();
			//MainP.gameP.setFocusToGameP();
			MainP.cardsL.show(MainP.cont, "game");//MainP is class -_> call static variable container 
		}
		else if(e.getSource()==instructions) {
			//go to instructions
			JOptionPane.showMessageDialog(null, "Instructions\n\nThe Kirby character can be moved using\nthe following keys: A, W, S, D.\nTo move up press W.\nTo move down press S.\nTo move left press A.\nTo move right press D.\n\nThe main objective in this game is to\ncollect stars while avoiding obstacles.\nYou are given 5 lives before Kirby dies.\nGetting hit by an obstacle will cause\nyou to lose a life.\nEach star collected adds 50 points to\nyour score.", "Instructions", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("spinningKirby.gif"));
		}
		else if(e.getSource()==highScore) {
			JOptionPane.showMessageDialog(null, "High Score");
		}
		else if(e.getSource()==exit) {
			JOptionPane.showMessageDialog(null, "Goodbye!");//make icon spinning kirby
			System.exit(0); 
		}
		      
		
	}
	
	public void makeClearButton(JButton b) {
		//set appearance
		b.setOpaque(false);
		b.setContentAreaFilled(false);
		b.setBorderPainted(false);
		b.setFocusPainted(false);
		//add action listener
		b.addActionListener(this);
		this.add(b);//add button
	}

}
