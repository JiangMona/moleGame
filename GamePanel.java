import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GamePanel extends JPanel{
	private StatsP stats;
	private PlayP play;

	public GamePanel() {
		
		//set layout
		stats= new StatsP();
		play= new PlayP();
		
		this.setLayout(new BorderLayout());
		this.add(stats, BorderLayout.SOUTH);
		this.add(play, BorderLayout.CENTER);
		
	}
	 public void setFocusToGameP() {
		 play.setFocusable(true);
		 play.requestFocus();
	 }
	
}