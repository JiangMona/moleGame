import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class PlayP extends JPanel implements KeyListener, MouseListener, ActionListener{
	private static ImageIcon player;
	private int x, y, mouseX, mouseY;
	private Timer myTimer;
	private JButton b;
	
	
	public PlayP() {
		addKeyListener( this );
		setBackground(Color.YELLOW);  
		player = new ImageIcon("kirbyFly.gif");
		x = 100;
		y = 300;
		b = new JButton("abc");
		setLayout(new FlowLayout());
		add(b);
		addMouseListener(this);
		addKeyListener(this);
		b.addKeyListener(this);
		
		myTimer = new Timer(120, this); 
	    myTimer.start();
		setFocusable(true);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(player.getImage(),x,y,120,80,null);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==myTimer){
			//x += 3;
			//y += 3;
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
		if(e.getKeyCode()==65) 
			x -= 10;
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("S"))
	     	y -= 10;
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("W"))
			y += 10;
		else if(KeyEvent.getKeyText(e.getKeyCode()).equals("D"))
			x += 10;	
		repaint();
	}
	
	public void keyReleased( KeyEvent e ) {   }
	public void keyTyped( KeyEvent e )   {   }
}
