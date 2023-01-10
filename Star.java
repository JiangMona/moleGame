/*
Name: Mona Jiang and Catharine Zhou
Class: ICS3U7-1
Teacher: Ms. Strelkovska
Assignment: Final Project
Description: Stars for Kirby Adventures game
*/

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Star extends Obstacles{
	
	public Star(int x, int y) {
		super(x, y);
		setImg(new ImageIcon("purpleStar.gif"));
	}
	
	public boolean isIceCube() {
		return false;
	}

}
