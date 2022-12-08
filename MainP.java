import java.awt.*;
import java.awt.image.*;
import java.io.IOException;

import javax.swing.JFrame;

//kirby
public class MainP extends JFrame{
	
	static CardLayout cardsL;//can't be private because we will be calling using other classes
	static Container cont;
	public static MenuPanel menuP;
	static GamePanel gameP;
	private InstructionsPanel instructionsP;
	
	public MainP(String title) throws FontFormatException, IOException {
		super(title);
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

}
