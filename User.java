import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class User {
	private int x,y;
	private boolean right;
	private boolean stay;
	private int vel;
	private BufferedImage playerImg=null;

   public User(int x,int y){
     this.x=x;
     this.y=y;
     vel=0;
     right=false;
     stay=true;  	 
   }
   public int getX(){
	   return x;
   }	   
   public void move(){
	x+=vel;   
   }
   public void setStay(){
	  stay=true; 
      right=false;   
      vel=0;
   } 
   public void setRight(){
	  right=true; 
      stay=false;   
      vel=40;
	} 	
		   
   public void myDraw(Graphics g){
	  if(stay)
        playerImg = Sprite.getBasicImg();
      else if(right)
        playerImg=	Sprite.getNextRight();
         
      g.drawImage(playerImg,x,y,null); 
   }	   

}
