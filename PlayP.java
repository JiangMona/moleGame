import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
public class PlayP extends JPanel implements KeyListener, MouseListener, ActionListener{
	private static ImageIcon player;
	private int x, y, mouseX, mouseY;
	private Timer myTimer;
	private JButton b;
	private boolean right;
	private boolean stay;
	private int vel;
	private User user;
	private BufferedImage playerImg=null;
	public PlayP() {
		addKeyListener( this );
		setBackground(Color.YELLOW);  
		player = new ImageIcon("kirbyFly.gif");
		x = 100;
		y = 300;
		b = new JButton("STARTGAME");
		setLayout(new FlowLayout());
		add(b);
		addMouseListener(this);
		addKeyListener(this);
		b.addKeyListener(this);
		////
		user = new User(0,0);
		Sprite.loadImages();
		
		myTimer = new Timer(120, this); 
	    myTimer.start();
		setFocusable(true);
		right=false;
	    stay=true;  
	}
	public void paintComponent(Graphics g){
		 super.paintComponent(g);
		 user.myDraw(g);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==myTimer){
			user.move();
			repaint();
		}
	}
	
	public void mouseClicked( MouseEvent me ){
	     
		 mouseX= me.getX();// x coordinates of mouse clicked
	     mouseY= me.getY();// y coordinates of mouse clicked
		 
	      x=mouseX;     // change x coordinates of the player to mouseX
	      y=mouseY;
	      repaint();   // call paintComponent method
	   }

	public void mousePressed( MouseEvent e ){   }
	public void mouseReleased( MouseEvent e ){   }
	public void mouseEntered( MouseEvent e ) {   }
	public void mouseExited( MouseEvent e )  {   }
	   
	public void keyPressed( KeyEvent e ){  
		System.out.println("ee");
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("A"))
			user.setLeft();
		
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("S"))
	     	user.setDown();
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("W"))
			user.setUp();
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("D"))
			user.setRight();
		repaint();
	}
	
	public void keyReleased( KeyEvent e ) {   
		user.setStay();
	}
	public void keyTyped( KeyEvent e )   {   }
}