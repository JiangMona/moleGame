import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class StatsP extends JPanel implements ActionListener, KeyListener{
	ImageIcon scoreBoard;
	private JButton back;
	
	public StatsP() {
		scoreBoard= new ImageIcon("scoreBoard.png");//make image object 
		JLabel score = new JLabel(scoreBoard);//add to a jlabal
		/*
		back = new JButton("back");
		back.addKeyListener( this );
		back.setBounds(500, 300, 200, 30);
		back.addActionListener(this);
		this.add(back);
		*/
		this.add(score);//add labal to panel
		
		setBackground(Color.ORANGE);  
		
		
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
