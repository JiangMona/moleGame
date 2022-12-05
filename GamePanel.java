import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GamePanel extends JPanel implements ActionListener{
	private JButton game;//instructions
	private JButton instructions;//level
	private JButton btn3;//exit
	private JButton exit;//exit
	private JButton back;//instructions
	
	public GamePanel() {
		game= new JButton();
		back = new JButton("back");
		this.add(back);
		back.addActionListener(this);
	}
	public void paintComponent(Graphics g) {//no double buffering --> double buffering: java creates off screen image and replaces entire screen
		super.paintComponent(g);;
		g.setFont(new Font("SansSerif", Font.ITALIC, 30));
		g.drawString("Game", 150, 150);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			MainP.cardsL.show(MainP.cont, "menu");
			//go to game
			
		}
		else if(e.getSource()==instructions) {
			//go to instructions
		}
		else if(e.getSource()==btn3) {
			
		}
		else if(e.getSource()==exit) {
			JOptionPane.showMessageDialog(null, "Goodbye!");//make icon spinning kirby
			System.exit(0); 
		}
		      
		
	}
	

}
