import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Obstacles{
	private ImageIcon icicle;
	private int x;
	private int y;
	
	public Obstacles(int x) {
		this.x = x;
		y = -3;//start a little before the screen for smoother transition
		icicle = new ImageIcon("ice.png");
	}
	
	public void moveObst() { //move down anf right
		
		if((int)(Math.random()*2) == 1) { //move left
			x += 1; 
			y += 3;
		}
		else {
			x -= 1;
			y += 3; //moev right
		}
			
	}
	
	
	public Rectangle getRect() {
		return new Rectangle(x, y, 40, 40);
	}
	
	public boolean isOutOfScreen() {
		if(y>450)
			return true;
		return false;
	}
	
	public void myDrawObst(Graphics g) {
		g.drawImage(icicle.getImage(), x, y, 40, 40, null);
	}
	
}