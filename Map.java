import java.awt.*;

import javax.swing.ImageIcon;

public class Map {
	private int map[][]= {//1 is land 0 is water
			{0,0,1,1,1,1,1,1,0,0,1,0},
			{1,0,1,1,0,0,0,0,0,0,0,1},
			{1,0,0,0,1,1,1,1,0,0,1,0},
			{1,1,1,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,0,0,1,1},
			{0,1,1,0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,1,1,0,0,1,0,1},
			{0,1,1,0,0,0,1,1,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1}
			
	};
	private ImageIcon water, land;
	
	public Rectangle getRect(int x, int y){
		return new Rectangle(x*50,y*50, 50, 50);   
	} 
	
	public boolean isLand(int x, int y) {
		if (map[x][y] == 1) {
			return true;
		}
		return false;
	}
	
	public void drawMap(Graphics g){
		water= new ImageIcon("water.gif");
		land= new ImageIcon("land.png");
		for (int i =0; i< map.length;i++) {
			 for (int j =0; j<map[0].length; j++) {
				 if (map[i][j]==0) {
					 g.drawImage(water.getImage(),j*50,i*50,50, 50, null);
				 }
				 else {
					 g.drawImage(land.getImage(),j*50,i*50,50, 50, null); 
					 g.drawRect(j*50,i*50,50, 50);

				 }
			 }
		 }
		
	   }	   
}