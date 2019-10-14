import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Game extends JPanel {
	JFrame frame = new JFrame("Chess");
	private final int TILE_WIDTH = 60;
	private final int TILE_HEIGHT = 60;
	private final int BOARD_BORDER_WIDTH = 60;
	private final int BOARD_BORDER_HEIGHT = 60;
	
	private final int TILES_X = 8;
	private final int TILES_Y = 8;
	
	private final int INITIAL_WIDTH = (TILES_X * TILE_WIDTH) + (2 * BOARD_BORDER_WIDTH);
	private final int INITIAL_HEIGHT = (TILES_Y * TILE_HEIGHT) + (2 * BOARD_BORDER_HEIGHT);
	
	private final int[][] tiles = new int[][] {
		{1,0,1,0,1,0,1,0},
		{0,1,0,1,0,1,0,1},
		{1,0,1,0,1,0,1,0},
		{0,1,0,1,0,1,0,1},
		{1,0,1,0,1,0,1,0},
		{0,1,0,1,0,1,0,1},
		{1,0,1,0,1,0,1,0},
		{0,1,0,1,0,1,0,1}
	};
	
	//Default constructor
	public Game() {
		//
		Board b = new Board(TILES_X, TILES_Y, TILE_WIDTH, TILE_HEIGHT, tiles);
		b.setBounds(BOARD_BORDER_WIDTH, BOARD_BORDER_HEIGHT, (TILES_X * TILE_WIDTH), (TILES_Y * TILE_HEIGHT));
		JLayeredPane layers = new JLayeredPane();
		layers.setPreferredSize(new Dimension(INITIAL_WIDTH, INITIAL_HEIGHT));
		layers.add(new Background(INITIAL_WIDTH, INITIAL_HEIGHT), 1);
		layers.add(b, 0);
		frame.add(layers);
		frame.setSize(INITIAL_WIDTH, INITIAL_HEIGHT);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
		//Resizes window to fit everything
		frame.pack();
		frame.setVisible(true);
	}
}
