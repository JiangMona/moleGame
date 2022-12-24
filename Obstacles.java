import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Obstacles{
	ImageIcon img;
	int x;
	int y;
	
	public Obstacles(int x, int y) {
		this.x = x;
		this.y = y;
		img = new ImageIcon("ice.png");
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
		return new Rectangle(x, y, 38, 38);
	}
	
	public boolean isOutOfScreen() {
		if(y>450)
			return true;
		return false;
	}
	
	public void myDraw(Graphics g) {
		g.drawImage(img.getImage(), x, y, 40, 40, null);
	}
	
}