import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Background extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int boardWidth;
	private final int boardHeight; 
	
	BufferedImage bg;
	
	public Background(int boardX, int boardY) {
		super();
		this.boardWidth = boardX;
		this.boardHeight = boardY;
		setSize(boardX, boardY);
		
		
		try {
			bg = ImageIO.read(getClass().getResource("bg.jpg"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0,0, boardWidth, boardHeight, null);
	}
}
