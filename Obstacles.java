/*
Name: Mona Jiang and Catharine Zhou
Class: ICS3U7-1
Teacher: Ms. Strelkovska
Assignment: Final Project
Description: Obstacles for Kirby Adventures game
*/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Obstacles{
	private ImageIcon img;
	private int x;
	int y;
	private int upDown;
	
	public Obstacles(int x, int y) {
		this.x = x;
		this.y = y;
		img = new ImageIcon("ice.png");
		upDown = 0;
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
	
	public void setUpDown(int i) {
		upDown = i;
	}
	
	public int getUpDown() {
		return upDown;
	}
	
	public void setImg(ImageIcon ic) {
		img = ic;
	}
	
	public void myDraw(Graphics g) {
		if (isIceCube())
			g.drawImage(img.getImage(), x, y, 40, 40, null);
		else
			g.drawImage(img.getImage(), x, y+upDown, 40, 40, null);
	}
	
}