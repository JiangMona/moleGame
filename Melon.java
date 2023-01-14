import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Melon extends Star{
	public Melon(int x, int y) {
		super(x, y);
		img= (new ImageIcon("melon.gif"));
	}
	
	
	public boolean isMelon() {
		return true;
	}
	public void myDraw(Graphics g) {
		g.drawImage(img.getImage(), x+7, y+7, 30, 30, null);
	}
}
