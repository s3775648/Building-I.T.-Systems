import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Board extends JPanel implements MouseListener {
	private final int tiles_x;
	private final int tiles_y;
	private final int tile_width;
	private final int tile_height;
	private final int[][] tileSpotArray;
	private Tile[][] tilesArray;
	public String pieceName = "Empty";

	Game game;

	public Board(int tiles_x, int tiles_y, int tile_width, int tile_height, int[][] tiles, int[][] pieceNumbers,
			Game game) {
		super();
		this.addMouseListener(this);
		this.tilesArray = new Tile[8][8];
		this.tileSpotArray = tiles;
		this.tiles_x = tiles_x;
		this.tiles_y = tiles_y;
		this.tile_width = tile_width;
		this.tile_height = tile_height;

		// Uses current game.
		this.game = game;

		setSize((tiles_x * tile_width), (tiles_y * tile_height));
		setBackground(Color.WHITE);
		setLayout(new GridLayout(8, 8));
		for (int y = 0; y < tiles.length; y++) {
			for (int x = 0; x < tiles[y].length; x++) {
				// Creates Tile variable as the below assignments are wrapped in an if
				// state which prevents add() and tilesArray[y][x] from accessing i if
				// Not created prior

				Tile i;

				// Cheap check to see if pieces are top or bottom of board, passes through
				// 'false' or 'true' to allow creation of pieces on tiles

				// 'tiles' and 'pieceNumbers' arrays are passed through constructor of
				// board and are housed in the Game.java file

				if (y > 4) {
					i = new Tile(tiles[y][x], y, x, pieceNumbers[y][x], true);
				} else {
					i = new Tile(tiles[y][x], y, x, pieceNumbers[y][x], false);
				}

				// Add tile Panel to Board panel
				add(i);

				// Inserts Tile into array at construction, means we can access each
				// Tile using this array

				// EXAMPLE: If we want tile at (1, 2) - We can call tilesArray[1][2]

				tilesArray[y][x] = i;

			}
		}
	}

	// Initializing Click counter and selection
	int clickCount = 0;
	Piece a ;
	Piece b ;
	
	@Override
	public void mouseClicked(MouseEvent e) {

		// Highlighting Selected tile

		Tile i = (Tile) this.getComponentAt(e.getX(), e.getY());
		i.setSelected(true);

		// Current Mouse click position
		// Divided by Tile height and width
		// Board Starting from top Starting From top-Left corner

		int currentPosX = e.getX() / 60;
		int currentPosY = e.getY() / 60;

		int[][] piecePosition = game.getPieceNumbers();

		String clickedTile;
		String playerColour = null;

		// Obtain Piece number identifier
		int currentPieceNumber = piecePosition[currentPosY][currentPosX];

		if (currentPieceNumber == 0) {
			clickedTile = pieceName;
			playerColour = "";
		} else {
			clickedTile = i.piece.getPieceName();
			if (i.piece.isWhite() == true) {
				playerColour = "White";
			} else if (i.piece.isWhite() == false) {
				playerColour = "Black";
			}
		}

		// Print to console
		System.out.println("*** MOUSE SELECTED ***");

		// Click Counter for identifying first/second clicks
		if (clickCount == 0) {
			System.out.println("Click Count : FirstCLick");

			// Replacing Piece to Temporary variables
			a = i.getPiece();
			clickCount++;
			
			
			System.out.println("Get Piece location: " + a);
			
			
		} else if (clickCount == 1) {
			System.out.println("Click Count : SecondClick");

			// Replacing Piece to Temporary variables

			b = i.getPiece();
			
			clickCount--;
			
			
			System.out.println("Get Piece location: " + b);
			
		
//			reseting values after second click.?
//			a = null;
//			b = null;
		}

		System.out.println("Piece Number: " + currentPieceNumber);
		System.out.println("Piece Name: " + playerColour + " " + clickedTile);

		// +1 For accurate positioning
		// E.g. Starting from 1 rather than 0
		System.out.println("Location X-Y: (" + (currentPosX + 1) + "," + (currentPosY + 1) + ") \n");

		// *********************************************************//

		//b.replacePiece(a);
		
		
		
		
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
