import java.awt.*;
import java.awt.image.BufferedImage;

public class User {
	private int x,y;
	private boolean flewRight, flyRight, flyLeft;//equal true for now, load left flying sprite
	private boolean stay, upDown;
	private int vel, vert;//left/right, up/down
	private int score, lives;
	private BufferedImage playerImg=null;
	boolean isDead;
	

   public User(int x, int y){
	   
     this.x=x;
     this.y=y;
     upDown = false;
     vel=0;
     flewRight=true;
     stay=true;  
     score = 0;
     lives = 5;
     isDead=false;
   }
   
   public int getScore() {
	   return score;
   }
   
   public int getLives() {
	   return lives;
   }
   
   public int getX(){
	   return x;
   }	   
   public int getY(){
	   return y;
   }
   public int getVel(){
	   return vel;
   }	   
   public int getVert(){
	   return vert;
   }
   
   
   public void move(){
	   //if (x < 0 || y <0 || x> 600 || y > 446)
	   if (x + vel < 0 || y + vert < 0||x + vel >= 570 || y + vert >= 406) { //out of screen
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
      vert=-5;
      
      
	} 
   public void setDown(){
	  upDown = true;
      stay=false;
      vel=0;
      vert=5;
	} 
		   
   public Rectangle getRect(){ //collisions with obstacles
	   return new Rectangle(x,y, 37, 37);   
   }
   
   public Rectangle getUserMoveRect() {//moving towards land
	   return new Rectangle(x+vel, y+vert, 37, 37);
   }
   
 
   public void loseLife() {
	   lives -= 1;
	   if(lives <= 0) {
		   lives = 5;
		   this.x = 1;
		   this.y = 300;
		   score = 0;
	   }
	   
   }
   public void setDead(boolean player) {
	   isDead=player;
   }
   public boolean getDead() {
	   return isDead;
   }
   
   public void addScore() {
	   score += 50;
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
         
      g.drawImage(playerImg,x,y,37, 37, null); 
      //g.drawRect(x,y,49, 49); 
   }	   

}