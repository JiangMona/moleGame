import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Obstacles{
	private ImageIcon icicle;
	private int x;
	private int y;
	
	public Obstacles(int x, int y) {
		this.x = x;
		this.y = y;
		y = -3;//start a little before the screen for smoother transition
		icicle = new ImageIcon("ice.png");
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean isIceCube() {
		return true;
	}
	
	public void moveObst() { //move down anf right
		
		if((int)(Math.random()*2) == 1) { //move left
			x += 1; 
			y += 4;
		}
		else {
			x -= 1;
			y += 4; //move right
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
	
	public void myDraw(Graphics g) {
		g.drawImage(icicle.getImage(), x, y, 40, 40, null);
	}
	
}
	