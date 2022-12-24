import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Star extends Obstacles{
	private ImageIcon star;
	private int x, y;
	
	public Star(int x, int y) {
		super(x, y);
		star = new ImageIcon("purpleStar.gif");
	}
	
	public boolean isIceCube() {
		return false;
	}
	
	public void myDraw(Graphics g) {
		g.drawImage(star.getImage(), x, y, 40, 40, null);
	}
}
