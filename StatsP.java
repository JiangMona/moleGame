import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class StatsP extends JPanel implements ActionListener{
	ImageIcon scoreBoard;
	private JButton back;
	
	public StatsP() {
		scoreBoard= new ImageIcon("scoreBoard.png");
		JLabel score = new JLabel(scoreBoard);
		back = new JButton("back");
		this.add(back);
		back.addActionListener(this);
		this.add(score);
		
	}
	public void paintComponent(Graphics g) {//no double buffering --> double buffering: java creates off screen image and replaces entire screen
		super.paintComponent(g);;
		g.setFont(new Font("SansSerif", Font.ITALIC, 30));
		g.drawString("Game", 150, 150);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			MainP.cardsL.show(MainP.cont, "menu");
			//go to menu

		}
	}

}
