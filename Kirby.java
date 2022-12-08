import java.io.IOException;
import java.awt.event.*;
import java.awt.*;

import javax.swing.JFrame;

public class Kirby{

	public static void main(String[] args) throws FontFormatException, IOException{
		MainP javaFrame = new MainP("Kirby Adventures");//my main frame 
		
		javaFrame.setSize(600, 600);
		javaFrame.setVisible(true);
		javaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
