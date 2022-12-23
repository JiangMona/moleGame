import java.awt.*;
import java.awt.image.BufferedImage;

public class User {
	private int x,y;
	private boolean flewRight, flyRight, flyLeft;//equal true for now, load left flying sprite
	private boolean stay, upDown;
	private int vel, vert;//left/right, up/down
	private BufferedImage playerImg=null;
	private int lives;

   public User(int x,int y){
     this.x=x;
     this.y=y;
     lives = 5;
     upDown = false;
     vel=0;
     flewRight=true;
     stay=true;  	 
   }
   public int getX(){
	   return x;
   }	   
   public int getY(){
	   return y;
   }
   public void move(){
	   //if (x < 0 || y <0 || x> 600 || y > 446)
	   if (x + vel < 0 || y + vert < 0||x + vel >= 570 || y + vert >= 406) {
		  setStay();
		   x+=0;
		   y+=0;
	   }
	   else {
	       x+=vel;
	       y+=vert;
	   }
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
	  upDown = true;
      stay=false;   
      vel=0;
      vert=-10;
	} 
   public void setDown(){
	  upDown = true;
      stay=false;
      vel=0;
      vert=+10;
	} 
		   
   public Rectangle getRect(){
	   return new Rectangle(x, y, 37, 37);   
   }
 
   public Rectangle getUserMoveRect() {
	   return new Rectangle(x+vel, y+vert, 37, 37);
   }
   
   public void respawn() {
	   x = 1;
	   y = 300;
	   lives--;
   }
   
   public void myDraw(Graphics g){
	  if(stay) {
		  if(flewRight)
			  playerImg = Sprite.getBasicRightImg();
		  else
			  playerImg = Sprite.getBasicLeftImg();
	  }
	  else if(upDown) {
		  if(flewRight) 
			  playerImg = Sprite.getNextRight();
		  else
			  playerImg = Sprite.getNextLeft();
	  }
      else if(flyRight)//flying
        playerImg=	Sprite.getNextRight();
      else if(flyLeft)//flying
          playerImg= Sprite.getNextLeft();
         
      g.drawImage(playerImg,x,y, 37, 37, null); 
      //g.drawRect(x,y,49, 49); 
   }	   

}