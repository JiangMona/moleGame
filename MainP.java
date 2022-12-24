import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;

import javax.swing.JFrame;

//kirb
public class MainP extends JFrame{
	
	static CardLayout cardsL;//can't be private because we will be calling using other classes
	static Container cont;
	private MenuPanel menuP;
	//private GamePanel gameP;
	private PlayP playP;
	
	public MainP(String str) {
		super(str);
		cont = getContentPane();
		cardsL=new CardLayout();
		cont.setLayout(cardsL);
		menuP= new MenuPanel();
		playP= new PlayP();

		cont.add("menu", menuP);
		cont.add("game", playP);//next after menu
		
		
		this.setContentPane(cont);
		cardsL.show(cont, "menu");
		
		setResizable(false);//cant stretch
	}
	
	public static void main(String[] args) {
		MainP javaFrame = new MainP("Kirby Adventures");//my main frame 
		javaFrame.setSize(600, 600);
		javaFrame.setVisible(true);
		javaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

}
