import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class User {
	private int x,y;
	private boolean right, left, flyRight, flyLeft;//equal true for now, load left flying sprite
	private boolean stay;
	private int vel, vert;//left/right, up/down
	private BufferedImage playerImg=null;

   public User(int x,int y){
     this.x=x;
     this.y=y;
     vel=0;
     right=false;
     left = false;
     stay=true;  	 
   }
   public int getX(){
	   return x;
   }	   
   public void move(){
	    x+=vel;
	    y+=vert;
   }
   public void setStay(){
	  stay=true; 
      right=false;  
      vel=0;
      vert=0;
   } 
   public void setRight(){
	  flyRight=true; 
	  flyLeft = false;
      stay=false;   
      vel=10;
      vert=0;
	} 
   public void setLeft(){
	  flyLeft=true;
	  flyRight=false;
      stay=false;   
      vel=-10;
      vert=0;
	} 
   public void setUp(){
      stay=false;   
      vel=0;
      vert=-10;
	} 
   public void setDown(){
      stay=false;
      vel=0;
      vert=+10;
	} 
		   
   public void myDraw(Graphics g){
	  if(stay)
        playerImg = Sprite.getBasicImg();
      else if(flyRight)//flying
        playerImg=	Sprite.getNextRight();
      else if(flyLeft)//flying
          playerImg= Sprite.getNextLeft();
         
      g.drawImage(playerImg,x,y,null); 
   }	   

}