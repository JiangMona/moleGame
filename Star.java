import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Star extends Obstacles{
	public Star(int x, int y) {
		super(x, y);
		img = new ImageIcon("purpleStar.gif");
	}
	
	public boolean isIceCube() {
		return false;
	}

}