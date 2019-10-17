import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Game extends JPanel implements MouseListener{
	JFrame frame = new JFrame("Chess");
	private final int TILE_WIDTH = 60;
	private final int TILE_HEIGHT = 60;
	private final int BOARD_BORDER_WIDTH = 60;
	private final int BOARD_BORDER_HEIGHT = 60;
	
	private final int TILES_X = 8;
	private final int TILES_Y = 8;
	
	private Board b;
	
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
	
	private final int[][] pieceNumbers = new int[][] {
		{2, 3, 4, 5, 6, 4, 3, 2},
		{1, 1, 1, 1, 1, 1, 1, 1},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{1, 1, 1, 1, 1, 1, 1, 1},
		{2, 3, 4, 6, 5, 4, 3, 2}
	};
	//Default constructor
	public Game() {
		//
		this.addMouseListener(this);
		b = new Board(TILES_X, TILES_Y, TILE_WIDTH, TILE_HEIGHT, tiles, pieceNumbers);
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

	public int[][] getPieceNumbers()
	{
		return pieceNumbers;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(b.pieceName);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
