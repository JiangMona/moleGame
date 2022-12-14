import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class User {
	private int x,y;
	private boolean flewRight, flyRight, flyLeft;//equal true for now, load left flying sprite
	private boolean stay;
	private int vel, vert;//left/right, up/down
	private BufferedImage playerImg=null;

   public User(int x,int y){
     this.x=x;
     this.y=y;
     vel=0;
     flewRight=true;
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
      flyRight = false;
      flyLeft = false;
      vel=0;
      vert=0;
   } 
   public void setRight(){
	  flyRight=true; 
	  flyLeft = false;
	  flewRight=true;
      stay=false;   
      vel=10;
      vert=0;
	} 
   public void setLeft(){
	  flyLeft=true;
	  flyRight=false;
	  flewRight=false;
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
	  if(stay) {
		  if(flewRight)
			  playerImg = Sprite.getBasicRightImg();
		  else
			  playerImg = Sprite.getBasicLeftImg();
	  }
      else if(flyRight)//flying
        playerImg=	Sprite.getNextRight();
      else if(flyLeft)//flying
          playerImg= Sprite.getNextLeft();
         
      g.drawImage(playerImg,x,y,40, 40, null); 
   }	   

}