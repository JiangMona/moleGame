import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.event.*;


public class Sprite_Demo{

  public static void main(String[] args) {
    JFrame f = new JFrame("Layout example");//java JFrame object
   
    Container cont = f.getContentPane();  // get container - top of the frame
	cont.setLayout(new BorderLayout());  // set Layout to Border 
	
	GamePanel game= new GamePanel();  // create an object of our game panel
	cont.add(game, BorderLayout.CENTER ); // add this game panel to the center of the frame
	 
	 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // make frame closed when x button is pressed
	 f.setVisible(true);     // make the frame visible
	 f.setSize(1000, 400);  // set the size of the frame
	 
	}//end of main
}//end of class

class GamePanel extends JPanel implements ActionListener, MouseListener{

   private Player player;
   private Timer myT;
   
   
   public GamePanel(){    // constructor
     	  
	  MyImages.loadImages();
      player= new Player (10,20);  // new player at the position 10,20
	  addMouseListener(this);
	  myT= new Timer(120,this);
	  myT.start();
   }// end of constructor
   
   
   public void paintComponent(Graphics g){
	   super.paintComponent(g);
	   player.myDraw(g);

   }//end of paint
    public void actionPerformed(ActionEvent e) {  // timer events
		player.move();
		repaint();
	}
    public void mouseClicked( MouseEvent e ){
     
	 int mouseX= e.getX();// x coordinates of mouse clicked
     int mouseY= e.getY();// y coordinates of mouse clicked
	 
      if(mouseX>player.getX())     // mouse is clicked on the right of the player
         player.setRight();
      else
         player.setStay();      // mouse is clicked on the left side in relates to the player
	 
	  repaint();   // call paintComponent method
   }

   public void mousePressed( MouseEvent e ){   }
   public void mouseReleased( MouseEvent e ){   }
   public void mouseEntered( MouseEvent e ) {   }
   public void mouseExited( MouseEvent e )  {   }

   
}//end of class
/////////////////////////////////////////////////////////////////////
class Player{
	private int x,y;
	private boolean right;
	private boolean stay;
	private int vel;
	private BufferedImage playerImg=null;

   public Player(int x,int y){
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
        playerImg = MyImages.getBasicImg();
      else if(right)
        playerImg=	MyImages.getNextRight();
         
      g.drawImage(playerImg,x,y,null); 
   }	   
}
/////////////////////////////////////////////////////////////////////////////	
class MyImages{
   /*private static BufferedImage spriteImg, basicImg;
   private static BufferedImage right[];
   private static int cnt=0;
	
	public static void loadImages(){
      try{
         spriteImg = ImageIO.read(new File("SpriteSh_1.png")); 
      }catch(Exception e){
	     System.out.print("Error" + e);
      }  
	  basicImg=spriteImg.getSubimage(203,14,48,112);
	  
      right= new BufferedImage[3];
   
      right[1]= spriteImg.getSubimage(0,299,83,106);
	  right[2]= spriteImg.getSubimage(203,299,48,116);
	  right[0]= spriteImg.getSubimage(351,309,83,102);
	}
    
    public static BufferedImage getNextRight(){
       cnt=(cnt+1)%right.length;
	   return right[cnt];
	}
    public static BufferedImage getBasicImg(){
	   return basicImg;
	}*/
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
	
	
	