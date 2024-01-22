import java.awt.Graphics;
import javax.swing.JPanel;

public class Panel extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setFont(new java.awt.Font("Times New Roman", 2, 24));
		g.drawString("My Shinobi Wolf, it's time for you to return, listen for my whistle", 50, 100);
	}

}
