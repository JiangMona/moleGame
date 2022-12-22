import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.*;
public class PlayP extends JPanel implements KeyListener, ActionListener{
	private Timer myTimer;
	private JButton b;
	private User user;
	private Map map;
	private ArrayList<Obstacles> obstacles;
	private int num;
	private int counter;
	
	//icons 

	public PlayP() {
		setBackground(Color.YELLOW);  
		b = new JButton("STARTGAME");
		setLayout(new FlowLayout());
		add(b);
		addKeyListener(this);
		b.addKeyListener(this);
		user = new User(1, 300);
		//obst = new Obstacles((int)(Math.random()*600));
		Sprite.loadImages();
		obstacles = new ArrayList<Obstacles>();
		
		for(int i = 0; i < 6; i ++) {
			obstacles.add(new Obstacles((int)(Math.random()*600) + 75, (int)(Math.random()*25)+150));
		}
		
		counter = 0;
		myTimer = new Timer(120, this); 
	    myTimer.start();
		setFocusable(true);
		map = new Map();
		
	}
	public void paintComponent(Graphics g){
		 super.paintComponent(g);
		 
		 map.drawMap(g);
		 user.myDraw(g);
		 for(int i = 0; i < obstacles.size();i++) {
				obstacles.get(i).MyDraw(g);
			}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==myTimer){
			for (int i =0; i<12; i++) {
				for (int j=0; j<9; j++) {
					if (map.isLand(j,i)) {
						if (user.getUserMoveRect().intersects(map.getRect(i,j))) {
							user.setStay();
						}
				
					}
				}
			}
			
			for (int i = 0; i < obstacles.size(); i++) {
				if(obstacles.get(i).getRect().intersects(user.getRect()))
					user.respawn();
			}
			
			counter++;
			if(counter%10 == 0) {
				obstacles.add(new Obstacles((int)(Math.random()*600), 0));
			}
			user.move();
			for(int i = 0; i < obstacles.size();i++) {
				if((int)(Math.random()*2) == 1)
					obstacles.get(i).moveObstLeft();
				else
					obstacles.get(i).moveObstRight();
			}
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