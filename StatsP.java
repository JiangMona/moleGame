import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class StatsP extends JPanel implements ActionListener{
	private JPanel p;
	private ImageIcon scoreBoard, back, startPause;
	private JButton backBtn, startPauseBtn;
	public StatsP() {
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		//p = new JPanel();
		//p.setLayout(new FlowLayout(FlowLayout.RIGHT));
		//add(p, BorderLayout.CENTER);
		back= new ImageIcon("back.png");
		backBtn = new JButton(back);
		startPause = new ImageIcon("pause.png");
		startPauseBtn = new JButton(startPause);
		makeClearButton(backBtn);
		makeClearButton(startPauseBtn);
		add(startPauseBtn);
		add(backBtn);
		//p.add(startPauseBtn);
		//p.add(backBtn);

	}
	public void paintComponent(Graphics g) {//no double buffering --> double buffering: java creates off screen image and replaces entire screen
		
		scoreBoard= new ImageIcon("scoreBoard.png");
		g.drawImage(scoreBoard.getImage(), 0, 0, 600, 150, null);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backBtn) {
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