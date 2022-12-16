import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
public class PlayP extends JPanel implements KeyListener, ActionListener{
	private Timer myTimer;
	private JButton b;
	private User user;
	private ImageIcon water, land;
	private int num;
	private int map[][]= {//1 is land 0 is water
			{0,0,1,1,1,1,1,1,0,0,1,0},
			{1,0,1,1,0,0,0,0,0,0,0,1},
			{1,0,0,0,1,1,1,1,0,0,1,0},
			{1,1,1,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,0,0,1,1},
			{0,1,1,0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,1,1,0,0,1,0,1},
			{0,1,1,0,0,0,1,1,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1}
			
	};
	//icons 

	public PlayP() {
		setBackground(Color.YELLOW);  
		b = new JButton("STARTGAME");
		setLayout(new FlowLayout());
		add(b);
		addKeyListener(this);
		b.addKeyListener(this);
		////
		user = new User(1, 400);
		Sprite.loadImages();
		
		myTimer = new Timer(120, this); 
	    myTimer.start();
		setFocusable(true);
		
		water= new ImageIcon("water.gif");
		land= new ImageIcon("land.png");
	}
	public void paintComponent(Graphics g){
		 super.paintComponent(g);
		 
		 for (int i =0; i< map.length;i++) {
			 for (int j =0; j<map[0].length; j++) {
				 if (map[i][j]==0) {
					 g.drawImage(water.getImage(),j*50,i*50,50, 50, null); 
				 }
				 else {
					 g.drawImage(land.getImage(),j*50,i*50,50, 50, null); 
				 }
			 }
		 }
		 user.myDraw(g); 
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==myTimer){
			user.move();
			
			repaint();
		}
	}
	public void keyPressed( KeyEvent e ){  
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("A")) {
			user.setLeft();
			System.out.println("move left");
		}
		
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("S")) {
	     	user.setDown();
	     	System.out.println("move down");
		}
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("W")) {
			user.setUp();
			System.out.println("move up");
		} 
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("D")) {
			user.setRight();
			System.out.println("move right");
		}
		repaint();
	}
	
	public void keyReleased( KeyEvent e ) {   
		user.setStay();
	}
	public void keyTyped( KeyEvent e )   {   }
}