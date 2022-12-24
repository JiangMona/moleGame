import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MenuPanel extends JPanel implements ActionListener{

	private JButton game;//instructions
	private JButton instructions;//level
	private JButton highScore;
	private JButton exit;//exit
	private ImageIcon back;
	private JLabel bg;
	private static ImageIcon startGame, highS, instruct, leave;
	public MenuPanel() {
		this.setLayout(null);//not using premade layout
		
		startGame = new ImageIcon("startGame.png");
		game = new JButton(startGame);//start from levl 1
		makeClearButton(game);
		/*
		game.setOpaque(false);
	    game.setContentAreaFilled(false);
	    game.setBorderPainted(false);
	    game.setFocusPainted(false);
	    */
	    instruct = new ImageIcon("instructions.png");
		instructions = new JButton(instruct); 
		makeClearButton(instructions);
	    
	    highS= new ImageIcon("highScore.png");
		highScore = new JButton(highS); 
		makeClearButton(highScore);
		
		leave= new ImageIcon("exit.png");
		exit = new JButton(leave); 
		makeClearButton(exit);
		//b1.setLocation(30, 200);
		//b1.setSize(200, 30);
		game.setBounds(75, 300, 200, 30); //same thing as set location and set size
		//this.add(game);//use _this_ to refer to the main panel itself
		instructions.setBounds(300, 300, 250, 30); 
		//this.add(instructions);
		highScore.setBounds(75, 400, 200, 30); 
		//this.add(highScore);
		exit.setBounds(325, 395, 200, 35); 
		//this.add(exit);
		
		//ADDED ACTION LISTENER IN METHOD
		back = new ImageIcon("background.gif");
		bg= new JLabel(back);
		bg.setBounds(0,0, 600, 600);
		add(bg);
		
	}
	public void paintComponent(Graphics g) {//no double buffering --> double buffering: java creates off screen image and replaces entire screen
		super.paintComponent(g);
		g.setFont(new Font("SansSerif", Font.ITALIC, 30));
		g.drawString("KIRBY ADVENTURES", 150, 150);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==game) {
			//go to game
			//MainP.cardsL.next(MainP.cont); //go to frame, go through layout, get next panel
			MainP.cardsL.show(MainP.cont, "game");//MainP is class -_> call static variable container 
		}
		else if(e.getSource()==instructions) {
			//go to instructions
			JOptionPane.showMessageDialog(null, "INSTRUCTION: JUMPJUMPJUAJEJDHKEAJFHKEJABFEKJAN UTKSVIUBKAY5EIV7K");
			JOptionPane.showMessageDialog(null, "BABABABABP");
		}
		else if(e.getSource()==highScore) {
			
		}
		else if(e.getSource()==exit) {
			JOptionPane.showMessageDialog(null, "Goodbye!");//make icon spinning kirby
			System.exit(0); 
		}
		      
		
	}
	
	public void makeClearButton(JButton b) {
		//set appearance
		b.setOpaque(false);
		b.setContentAreaFilled(false);
		b.setBorderPainted(false);
		b.setFocusPainted(false);
		//add cation listener
		b.addActionListener(this);
		this.add(b);//add button
	}

}
