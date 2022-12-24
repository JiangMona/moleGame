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
		
		obstacles = new ArrayList<Obstacles>(); //initial obstacles first on screen
		counter = 0; //count time
		
		for(int i = 0; i < 3; i++) { // spawn a few ice cubes at first so the user can't just run past the first row 
			obstacles.add(new Obstacles((int)(Math.random()*500)+50, 125));
		}
		
		myTimer = new Timer(120, this); 
	    myTimer.start();
		setFocusable(true);
		map = new Map();
		
		for (int i =0; i<12; i++) {
			for (int j=0; j<9; j++) {
				if (map.isLand(j,i)) {
					obstacles.add(new Star(i*50, j*50));
			
				}
			}
		}
		
	}
	public void paintComponent(Graphics g){
		 super.paintComponent(g);
		 
		 map.drawMap(g);
		 
		 user.myDraw(g);
	
		 for(int i = 0; i < obstacles.size();i++) {
				obstacles.get(i).myDraw(g);
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
			
			counter++;
			
			if(counter%15 == 0) {
				obstacles.add(new Obstacles((int)(Math.random()*600), -3));//x coordinate of obstacle to be dropped 
			}
			
			for(int i = 0; i < obstacles.size();i++) {
				//collisions, moving and removing obstacles
				if(obstacles.get(i).isIceCube()) 
					obstacles.get(i).moveObst();
				if(obstacles.get(i).getRect().intersects(user.getRect())) {
					if(obstacles.get(i).isIceCube()) {
						user.loseLife();
						obstacles.get(i).setY(obstacles.get(i).getY() + 50);
					}
					else {
						user.addScore();
						obstacles.remove(i);
					}
				}
				
				if(obstacles.get(i).isOutOfScreen()) {
					obstacles.remove(i);
					System.out.println("REMOVED");
				}
			}
			
			//move user and repaint
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
	//	repaint();
	}
	
	public void keyReleased( KeyEvent e ) {   
		user.setStay();
	}
	public void keyTyped( KeyEvent e )   {   }
}