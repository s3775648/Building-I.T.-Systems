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
	public String pieceName = "Empty Tile - Not Occupied";



	public Board(int tiles_x, int tiles_y, int tile_width, int tile_height, int[][] tiles, int[][] pieceNumbers) {
		super();
		this.addMouseListener(this);
		this.tilesArray = new Tile[8][8];
		this.tileSpotArray = tiles;
		this.tiles_x = tiles_x;
		this.tiles_y = tiles_y;
		this.tile_width = tile_width;
		this.tile_height = tile_height;
		
	
		
		
		setSize((tiles_x * tile_width) , (tiles_y * tile_height));
		setBackground(Color.WHITE);
		setLayout(new GridLayout(8,8));
		for(int y = 0; y < tiles.length; y++) {
			for(int x = 0; x < tiles[y].length; x++) {
				//Creates Tile variable as the below assignments are wrapped in an if
				//state which prevents add() and tilesArray[y][x]  from accessing i if 
				//Not created prior
				
				Tile i;
				
				//Cheap check to see if pieces are top or bottom of board, passes through
				//'false' or 'true' to allow creation of pieces on tiles
				
				//'tiles' and 'pieceNumbers' arrays are passed through constructor of
				//board and are housed in the Game.java file
				
				if(y > 4) {
					i = new Tile(tiles[y][x], y, x, pieceNumbers[y][x], true);
				} else {
					i = new Tile(tiles[y][x], y, x, pieceNumbers[y][x], false);
				}
				
				//Add tile Panel to Board panel
				add(i);
				
				//Inserts Tile into array at construction, means we can access each
				//Tile using this array 
				
				//EXAMPLE: If we want tile at (1, 2) - We can call tilesArray[1][2]
				
				tilesArray[y][x] = i;
				
			}
		}
	}
	
	
	// Basic Categorization for pieces.
	public String getPieceName(int pieceNumber) {
		switch(pieceNumber) {
		case 0: 
			break;
		case 1:
			if(pieceNumber == 1)
				return "Pawn";
			break;
		case 2:
			if(pieceNumber == 2)
				return "Rook";
			break;
		case 3:
			if(pieceNumber == 3)
				return "Bishop";
			break;
		case 4:
			if(pieceNumber == 4)
				return "Knight";
			break;
		case 5:
			if(pieceNumber == 5)
				return "Queen";
			break;
		case 6:
			if(pieceNumber == 6)
				return "King";
			break;
		default:
			System.out.println("ERROR");
		}
		// When tile isn't occupied, returns default message
		return pieceName;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
		// Highlighting Selected tile
		
		Tile i = (Tile) this.getComponentAt(e.getX(), e.getY());
		i.setSelected(true);

	
	}

	@Override
	public void mousePressed(MouseEvent e) {

		
		//Current Mouse click position 
		//Divided by Tile height and width
		
		int currentPosX = e.getX()/60;
		int currentPosY = e.getY()/60;
		
		// Starting From top-Left corner
		
		int clickedX = currentPosX ;
		int clickedY = currentPosY ; 
		
		//Test Click
		// +1 For accurate positioning
		// E.g. Starting from 1 rather than 0
		
		System.out.println("X,Y Axis : " + (clickedX+1) + " , "+ (clickedY+1));
		
		//Initializing new Game in conflict with current game
		// Need to find a solution continue without restarting.
		Game game = new Game();
		
		
	    int[][] piecePosition = game.getPieceNumbers();
	    
	    // Obtain Piece number identifier
	    int currentPieceNumber = piecePosition[clickedY][clickedX];
	    
	    //Convert number into Name
	    String currentPiece = getPieceName(currentPieceNumber);
	   
	    // Print to console
	    System.out.println("Piece Number: " +currentPieceNumber +  " \nPiece Name:   " + currentPiece);
	    System.out.println();
	  
	
	   
	
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
