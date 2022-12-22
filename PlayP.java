import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
public class PlayP extends JPanel implements KeyListener, ActionListener{
	private Timer myTimer;
	private JButton b;
	private User user;
	private Map map;
	
	private int num;
	
	//icons 

	public PlayP() {
		setBackground(Color.YELLOW);  
		b = new JButton("STARTGAME");
		setLayout(new FlowLayout());
		add(b);
		addKeyListener(this);
		b.addKeyListener(this);
		////
		user = new User(1, 300);
		Sprite.loadImages();
		
		myTimer = new Timer(120, this); 
	    myTimer.start();
		setFocusable(true);
		map = new Map();
		
	}
	public void paintComponent(Graphics g){
		 super.paintComponent(g);
		 
		 map.drawMap(g);
		 user.myDraw(g); 
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==myTimer){
			
			for (int i =0; i<12; i++) {
				for (int j=0; j<9; j++) {
					if (map.isLand(j,i)) {
						if (user.getUserMoveRect().intersects(map.getRect(i,j))) {
							user.setStay();
							System.out.println("e");
						}
				
					}
				}
			}	
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