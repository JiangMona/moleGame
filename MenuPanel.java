import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.InputStream;

public class MenuPanel extends JPanel implements ActionListener{

	private JButton game;//instructions
	private JButton instructions;//level
	private JButton btn3;//exit
	private JButton exit;//exit
	//private Font pixelFont;
	private ImageIcon bg;
	private JLabel kirbyBg;
	
	public MenuPanel() throws FontFormatException, IOException {
		this.setLayout(null);//not using premade layout
		game = new JButton("START GAME");//start from level 1
		instructions = new JButton("INSTRUCTIONS"); 
		btn3 = new JButton("EXTRA BUTTON"); 
		exit = new JButton("EXIT"); 
		bg = new ImageIcon("background.gif");
		kirbyBg = new JLabel(bg);
		//InputStream font = getClass().getResourceAsStream("PixelFont.ttf");
		//pixelFont = Font.createFont(Font.TRUETYPE_FONT, font);
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
		kirbyBg.setBounds(0, 0, 600, 600);
		this.add(kirbyBg);
	}
	public void paintComponent(Graphics g) {//no double buffering --> double buffering: java creates off screen image and replaces entire screen
		super.paintComponent(g);;
		/*try {
			g.drawImage(ImageIO.read(new File("background.png")), 0, 0, this);
			//g.drawImage(ImageIO.read(new File("kirbyBg.png")), 0, 0, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		g.setFont(new Font("SansSerif", Font.ITALIC, 30));
		//g.setFont(pixelFont);
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
