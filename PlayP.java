import java.awt.*;
import java.awt.event.*;
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
	private StatsP myStats;
	private ImageIcon startPause;;
	
	//icons 

	public PlayP() { 
		
		setLayout(new BorderLayout());
		myStats= new StatsP();
		add(myStats, BorderLayout.SOUTH);
		startPause = new ImageIcon("pause.png");
		b = new JButton(startPause);
		b.setOpaque(false);
		b.setContentAreaFilled(false);
		b.setBorderPainted(false);
		b.setFocusPainted(false);
		b.addKeyListener(this);//for setting focus
		
		addKeyListener(this);
		myStats.add(b);
		user = new User(1, 300);
		
		//obst = new Obstacles((int)(Math.random()*600));
		Sprite.loadImages();
		myTimer = new Timer(120, this); 
	    myTimer.start();
		setFocusable(true);
		map = new Map();
		
		obstacles = new ArrayList<Obstacles>(); //initial obstacles first on screen
		counter = 0; //count time
		
		
		for(int i = 0; i < 3; i++) { // spawn a few ice cubes at first so the user can't just run past the first row 
			Obstacles ice = new Obstacles((int)(Math.random()*500)+50, 125);
			obstacles.add(ice);
		}
		
		resetStars();
	}
	public void paintComponent(Graphics g){
		 super.paintComponent(g);
		 
		 map.drawMap(g);
		 
		 user.myDraw(g);
	
		 for(int i = 0; i < obstacles.size();i++) {
				obstacles.get(i).myDraw(g);
		 }
	}
	
	public void resetStars() {
		for(int i = 0; i < obstacles.size(); i++) { // remove current stars before adding new ones
			if(!obstacles.get(i).isIceCube())
				obstacles.remove(i);
		}
		for (int i =0; i<12; i++) {
			for (int j=0; j<9; j++) { 
				if ((int)(Math.random()*5+1)%5==0 && !map.isLand(j,i) && !(j==6 && i==0)) { //make stars spawn randomly but not where kirby spawns
						Obstacles star = new Star(i*50, j*50);
						obstacles.add(star);
				}
			}
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
					if(obstacles.get(i).isIceCube()) {  //move ice down
						if(user.getLives() - 1<= 0) {
							resetStars();
							myStats.resetScore();//////////////
						}
						user.loseLife();
						myStats.setLives(user.getLives());
						obstacles.get(i).setY(obstacles.get(i).getY() + 70);
					}
					
					else {//is star
						user.addScore();
						myStats.setScore(user.getScore()); 
						obstacles.remove(i); //remove star
						System.out.println("yum");
						System.out.println(user.getScore());
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
			//System.out.println("move left");
		}
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("S")) {
	     	user.setDown();
	     	//System.out.println("move down");
		}
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("W")) {
			user.setUp();
			//System.out.println("move up");
		} 
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("D")) {
			user.setRight();
			//System.out.println("move right");
		}
	//	repaint();
	}
	
	public void keyReleased( KeyEvent e ) {   
		user.setStay();
	}
	public void keyTyped( KeyEvent e )   {   }
}