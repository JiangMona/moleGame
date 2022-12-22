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
		icicle = new ImageIcon("ice.png");
	}
	
	public void moveObstLeft() {
		x += 1;
		y += 3;
	}
	
	public void moveObstRight() {
		x -= 1;
		y += 3;
	}
	
	public Rectangle getRect() {
		return new Rectangle(x, y, 40, 40);
	}
	
	public void MyDraw(Graphics g) {
		g.drawImage(icicle.getImage(), x, y, 40, 40, null);
		System.out.println(x);
		System.out.println(y);
	}
	
}
