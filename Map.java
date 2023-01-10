import java.awt.*;
import java.io.File;
import java.util.Scanner;
import javax.swing.ImageIcon;

public class Map {
	/*
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
	*/
	private int map[][]= new int[9][12];
	private ImageIcon water, land;
	private int upDown, vert;
	
	
	
	public Map() {
		try {
			Scanner scFile = new Scanner(new File("map1.txt"));
			for (int i =0; i< 9; i++) {
				String str=scFile.nextLine();
				for (int j=0; j<12; j++) {
					int block=Integer.parseInt(str.substring(j*2, j*2+1)); //skip over the commas
					map[i][j]=block;
				}
			}
			scFile.close();
		}
		
		
		catch(Exception e){
			System.out.println("Error: "+e);
		}
		vert =0;
		
	}
	
	public void setMove(int i) {
		upDown+= i;
	}
	
	
	public Rectangle getRect(int x, int y){
		return new Rectangle(x*50,y*50+upDown, 50, 50);   
	} 
	
	public Rectangle getNextRect(int x, int y){
		return new Rectangle(x*50,y*50+upDown+vert, 50, 50);   
	} 
	
	public boolean isLand(int x, int y) {
		if (map[x][y] == 1) {
			return true;
		}
		return false;
	}
	
	public void setVert(int i) {
		vert = i;
	}
	
	public void setUpDown(int i) {
		upDown = i;
	}
	
	public int getUpDown() {
		return upDown;
	}
	
	public void drawMap(Graphics g){
		water= new ImageIcon("water.gif");
		land= new ImageIcon("land.png");
		for (int i =0; i< map.length;i++) { //fill map from up to down, left to right
			 for (int j =0; j<map[0].length; j++) {
				 if (map[i][j]==0) {
					 g.drawImage(water.getImage(),j*50,i*50+upDown,50,50, null); 
				 }
				 else {
					 g.drawImage(land.getImage(),j*50,i*50+upDown,50,50, null); 
					 //g.drawRect(j*50,i*50,50, 50);

				 }
			 }
		 }
		
	   }	   
}