import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
public class StatsP extends JPanel implements ActionListener{
	private JPanel p;
	private ImageIcon scoreBoard, back;
	private JButton backBtn;
	private JLabel showScore, showLives;
	private int score, lives;
	private ArrayList<Integer> myScores;
	
	public StatsP() {
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		back= new ImageIcon("back.png");
		backBtn = new JButton(back);
		makeClearButton(backBtn);
		score=0;
		showScore = new JLabel("Score: 0      ");
		showScore.setFont(new Font("Verdana", Font.PLAIN, 18));
		showLives = new JLabel("Lives: 5      ");
		showLives.setFont(new Font("Verdana", Font.PLAIN, 18));
		add(showScore);
		add(showLives);
		add(backBtn);
		myScores= new ArrayList<Integer>();
	}
	public void setScore(int x) {
		score = x;
		showScore.setText("Score: "+x+"     ");
		
	}
	
	public void setLives(int x) {
		lives = x;
		showLives.setText("Lives: "+x+"          ");
	}
	
	public void resetScore() {
		//later add o array list of scores to find high score
		myScores.add(score);
		setScore(0);
		
	}
	public int getHighSchore() {
		int max=0;
		for (int i =0; i< myScores.size(); i++) {
			if (max< myScores.get(i)) {
				max = myScores.get(i);
			}
		}
		return max;
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
		//listener
		b.addActionListener(this);
	}

}