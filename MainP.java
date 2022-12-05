import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.*;

import javax.swing.JFrame;

//kirb
public class MainP extends JFrame{
	
	static CardLayout cardsL;//can't be private because we will be calling using other classes
	static Container cont;
	private MenuPanel menuP;
	private GamePanel gameP;
	private InstructionsPanel instructionsP;
	
	public MainP() {
		cont = getContentPane();
		cardsL=new CardLayout();
		cont.setLayout(cardsL);
		
		menuP= new MenuPanel();
		gameP= new GamePanel();
		instructionsP= new InstructionsPanel();
		
		cont.add("menu", menuP);
		cont.add("game", gameP);//next after menu
		cont.add("instructions", instructionsP);
		this.setContentPane(cont);
		cardsL.show(cont, "menu");
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainP javaFrame = new MainP();//my main frame 
		
		javaFrame.setSize(600, 600);
		javaFrame.setVisible(true);
		javaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
