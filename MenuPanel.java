import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MenuPanel extends JPanel implements ActionListener{

	private JButton game;//instructions
	private JButton instructions;//level
	private JButton btn3;//exit
	private JButton exit;//exit
	
	public MenuPanel() {
		this.setLayout(null);//not using premade layout
		game = new JButton("START GAME");//start from levl 1
		instructions = new JButton("INSTRUCTIONS"); 
		btn3 = new JButton("EXTRA BUTTON"); 
		exit = new JButton("EXIT"); 
		
		//b1.setLocation(30, 200);
		//b1.setSize(200, 30);
		game.setBounds(75, 300, 200, 30); //same thing as set location and set size
		this.add(game);//use _this_ to refer to the main panel itself
		instructions.setBounds(300, 300, 200, 30); 
		this.add(instructions);
		btn3.setBounds(75, 400, 200, 30); 
		this.add(btn3);
		exit.setBounds(300, 400, 200, 30); 
		this.add(exit);
		
		game.addActionListener(this);
		instructions.addActionListener(this);
		btn3.addActionListener(this);
		exit.addActionListener(this);
	}
	public void paintComponent(Graphics g) {//no double buffering --> double buffering: java creates off screen image and replaces entire screen
		super.paintComponent(g);;
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
			MainP.cardsL.show(MainP.cont, "instructions");
		}
		else if(e.getSource()==btn3) {
			
		}
		else if(e.getSource()==exit) {
			JOptionPane.showMessageDialog(null, "Goodbye!");//make icon spinning kirby
			System.exit(0); 
		}
		      
		
	}

}
