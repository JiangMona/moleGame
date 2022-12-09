import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class StatsP extends JPanel implements ActionListener{
	private ImageIcon scoreBoard, back;
	private JButton backbtn;
	public StatsP() {
		this.setLayout(new BorderLayout());
		
		back= new ImageIcon("b.png");
		backbtn = new JButton(back);
		makeClearButton(backbtn);
		add(backbtn, BorderLayout.EAST);

	
	}
	public void paintComponent(Graphics g) {//no double buffering --> double buffering: java creates off screen image and replaces entire screen
		
		scoreBoard= new ImageIcon("scoreBoard.png");
		g.drawImage(scoreBoard.getImage(), 0, 0, 600, 150, null);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backbtn) {
			MainP.cardsL.show(MainP.cont, "menu");
			//go to menu

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
	}

}
