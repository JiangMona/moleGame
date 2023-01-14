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
	private ImageIcon startPause;
	private boolean isFlyUp;
	private int timesPlayed;
	
	
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
		user = new User(0,300);
		
		//obst = new Obstacles((int)(Math.random()*600));
		Sprite.loadImages();
		myTimer = new Timer(120, this); 
	    myTimer.start();
		setFocusable(true);
		map = new Map();
		
		obstacles = new ArrayList<Obstacles>(); //initial obstacles first on screen
		counter = 0; //count time
		resetObstacles();
		
		timesPlayed = 0;
	}
	public void paintComponent(Graphics g){
		 super.paintComponent(g);
		 
		 map.drawMap(g); 
		 user.myDraw(g);
	
		 for(int i = 0; i < obstacles.size();i++) {
				obstacles.get(i).myDraw(g);
		 }
	}
	
	public void resetObstacles() {
		for(int i = 0; i < obstacles.size(); i=0) {
			obstacles.remove(i);
			System.out.println(obstacles.size());
		}
		
		for(int i = 0; i < 3; i++) { // spawn a few ice cubes at first so the user can't just run past the first row 
			Obstacles ice = new Obstacles((int)(Math.random()*461)+50, 125);
			obstacles.add(ice);
		}
		
		for (int i =0; i<12; i++) {
			for (int j=1; j<map.getRows()-1; j++) { //solves overlap
				if ((int)(Math.random()*2+1)%2==0 &&!map.isLand(j,i) && !(j==7 && i==0)) { //make stars spawn randomly but not where kirby spawns
						if ((int)(Math.random()*4+1)%4!=0){
							Obstacles star = new Star(i*50, (j-map.getShift())*50);
							obstacles.add(star);
						}
						else {
								Obstacles melon = new Melon(i*50, (j-map.getShift())*50);
								obstacles.add(melon);
							}
						
				}
			}
		}
	}
	
	public boolean hitLand() {

		for (int i =0; i<12; i++) {
			for (int j=0; j<map.getRows(); j++) { //(int)(Math.random()*5+1)%5==0 && 
				if (map.isLand(j,i)) {
						if (user.getUserMoveRect().intersects(map.getRect(i,j-map.getShift()))) {
							return true;
					}
					
					/*
					if (user.getRect().intersects(map.getRect(i,j))) {
						return true;
					}
					*/
			
				}
			}
		}
		return false;
	}
	
	public void addStars(int row) {
		for (int i =0; i<12; i++) { //(int)(Math.random()*2+1)%2==0 && 
			if ((int)(Math.random()*2+1)%2==0 &&!map.isLand(row,i)) { 
				Obstacles star = new Star(i*50, (row-1)*50);//row-1 bc row is hidden
				if ((int)(Math.random()*3+1)%3!=0){
				//	System.out.println(map.getRect(row,i).getX());
				//	System.out.println(user.getY()%50);
					System.out.println(counter);
					obstacles.add(star);
				}
				else {
					Obstacles melon = new Melon(i*50, (row-1)*50);
					obstacles.add(melon);
					
				}
			}
		}
	}
	
	public boolean starInLand(Obstacles s) {
		for (int i =0; i<12; i++) {
			for (int j=0; j<map.getRows(); j++) {
				if (map.isLand(j,i)) {
					if (s.getRect().intersects(map.getRect(i,j-map.getShift())))
						return true;
			
				}
			}
		}
		return false;
	}
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==myTimer){
			
			if (hitLand()) {
				//map.setMove(0);
				user.setStay();
			}
			map.setMove(-user.getVert());
			counter++;
			
			if(counter%15 == 0) {
				obstacles.add(new Obstacles((int)(Math.random()*561), -3));//x coordinate of obstacle to be dropped 
			}
			
			//collisions, obstacles, resetting 
			
			
			for(int i = 0; i < obstacles.size();i++) {
				
				//collisions, moving and removing obstacles
				if(obstacles.get(i).isIceCube()) {
					if  (user.getVert()>=0) //make ice cube move faster if user if moving up
						obstacles.get(i).moveObst(4);
					else
						obstacles.get(i).moveObst(10);
				}
				else {
					obstacles.get(i).setY(-user.getVert()); //moving stars
				/*
					if (starInLand(obstacles.get(i))) {
						obstacles.remove(i);
						break;
					}
				*/
				}
				
				if(obstacles.get(i).getRect().intersects(user.getRect())) {
					if(obstacles.get(i).isIceCube()) {  //move ice down
						
						if(user.getLives() - 1<= 0) {//part of lose lifes
							myStats.resetScore();//////////////
							map.reset();
							
							resetObstacles();
							//user.setY(0);//helps align stars
							user=new User(0,300);
							timesPlayed++;
							//user.loseLife(); //
							myStats.setLives(user.getLives());
							counter=0;
							break;
						}
						user.loseLife();						
						myStats.setLives(user.getLives());
						obstacles.get(i).setY(75);
					}
					else {
					
						if (obstacles.get(i).isMelon()) {
							user.addScore(75);
						}
						
						else {//is star
							user.addScore();
							
						}
						myStats.setScore(user.getScore()); 
						obstacles.remove(i); //remove star
					}
				}
				if(obstacles.get(i).isOutOfScreen()) { //remove stars and icicles out of screen
					obstacles.remove(i);
					System.out.println("REMOVED");
				}
			}

			if (map.getStarsUp()) {
				addStars(0); //add stars to row//index of array
			}
			if (map.getStarsDown()) {
				addStars(10);
			}
			
			
			
			
			//move user and repaint
			//System.out.println(counter1);
			repaint();
			user.move();
		}
	}
	public void keyPressed( KeyEvent e ){  
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("A")) {
			user.setLeft();
			//System.out.println("move left");
		}
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("S")) {
		
		    // 	map.setMove(-10);
		     	user.setDown();
		     	isFlyUp=true;
		   
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
	
	
	public int getHighScore (){
		return myStats.getHighScore();
	}
	
	public int getTimesPlayed() {
		return timesPlayed;
	}
	
}