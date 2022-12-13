import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Sprite {
	private static BufferedImage spriteImg, basicImg;
	   private static BufferedImage fly[];
	   private static int cnt=0;
		
		public static void loadImages(){
			try{
				spriteImg = ImageIO.read(new File("kirbySprite.png")); 
		   
			}catch(Exception e){
			    System.out.print("Error" + e);
		    }  
			basicImg=spriteImg.getSubimage(9,161,21,21);
			  
			fly= new BufferedImage[3];
		   
			fly[1]= spriteImg.getSubimage(9,161,21,21);
			fly[2]= spriteImg.getSubimage(33,161,21,21);
			fly[0]= spriteImg.getSubimage(57,161,21,21);		
		}
		
	    public static BufferedImage getNextRight(){
	       cnt=(cnt+1)%fly.length;
		   return fly[cnt];
		}
	    public static BufferedImage getBasicImg(){
		   return basicImg;
		}
}