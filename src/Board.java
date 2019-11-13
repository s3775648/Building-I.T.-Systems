import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Board extends JComponent implements MouseListener {
	private final int tiles_x;
	private final int tiles_y;
	private final int tile_width;
	private final int tile_height;
	private final int[][] tileSpotArray;
	private Tile[][] tilesArray;
	public String pieceName = "Empty";
	
	//Mouse click variables
	
	private int clickCount = 0;
	
	private Tile sourceTile;
	private Tile destinationTile;
	
	private Piece sourcePiece;
	private Piece destinationPiece;
	
	List<int[][][]> moves = new ArrayList<int[][][]>();

	Game game;

	public Board(int tiles_x, int tiles_y, int tile_width, int tile_height, int[][] tiles, int[][] pieceNumbers,
			Game game) {
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
	
	@Override
	public void mouseClicked(MouseEvent e) {

		//Get the tile

		Tile i = (Tile) this.getComponentAt(e.getX(), e.getY());

		//Handles click based on if it is first or second click
		if (clickCount == 0) {
			sourceTile = i;
			moves = determineMoves(sourceTile);
			for(int item = 0; item < moves.size(); item++) {
				for(int dir = 0; dir < moves.get(item).length; dir++) {
					if(moves.get(item)[dir].length > 0) {
						for(int move = 0; move < moves.get(item)[dir].length; move++) {
							System.out.println("Y: "+moves.get(item)[dir][move][0]+", X: "+moves.get(item)[dir][move][1]);
							int indexY = moves.get(item)[dir][move][0];
							int indexX = moves.get(item)[dir][move][1];
							
							tilesArray[indexY][indexX].setHighlighted(true);
						}
					}
				}
			}
			System.out.println("Click count set to 1");
			clickCount = 1;
		} else if (clickCount == 1) {
			destinationTile = i;
			
			if(sourceTile == destinationTile) {
				sourceTile.setSelected(false);
			}
			
			int xx = destinationTile.getIndexX();
			int yy = destinationTile.getIndexY();
			
			if(destinationTile.isHighlighted()) {
				sourcePiece = sourceTile.getPiece();
				destinationPiece = destinationTile.getPiece();
				
				sourceTile.removePiece();
				destinationTile.removePiece();
				destinationTile.setPiece(sourcePiece);
				
				System.out.println("Move is successful");
			}
			
			for(int y = 0; y < tilesArray.length; y++) {
				for(int x = 0; x < tilesArray[y].length; x++) {
					tilesArray[y][x].setHighlighted(false);
				}
			}
			System.out.println("Click count set to 0");
			clickCount = 0;
		}	
	}
	
	

	private List<int[][][]> determineMoves(Tile tile) {
		// TODO Auto-generated method stub
		Piece piece = tile.getPiece();
		int[][][] moves = piece.canMove();
		int tileX = tile.getIndexX();
		int tileY = tile.getIndexY();
		
		List<int[][][]> possibleMoves = new ArrayList<int[][][]>();
		//{Direction
		// {Move} {Move}
		
		for(int dir = 0; dir < moves.length; dir++) {
			List<int[]> directionMoves = new ArrayList<int[]>();
			boolean foundContact = false;
			for(int move = 0; move < moves[dir].length; move++) {
				//0 = Y, 1 = X

				int[] newMove = new int[] {tileY + moves[dir][move][0], tileX + moves[dir][move][1]};
				
				if(newMove[0] > 7 || newMove[0] < 0 || newMove[1] > 7 || newMove[1] < 0) {
					System.out.println("Invalid move"); //Add location later
				} else {
					if(tilesArray[newMove[0]][newMove[1]].getPiece() != null && foundContact == false) {
						directionMoves.add(newMove);
						foundContact = true;
						break;
					}
					
					if(tilesArray[newMove[0]][newMove[1]].getPiece() == null) {
						directionMoves.add(newMove);
					}
				}
			}
			int[][] directionArray = new int[directionMoves.size()][2];
			//System.out.println(directionMoves.size());
			
			directionMoves.forEach(move -> {
				try {
					directionArray[directionMoves.indexOf(move)] = new int[] {move[0], move[1]};
					//System.out.println(directionArray.length);
				} catch (IndexOutOfBoundsException e) {
					System.out.println(e);
				}
			});
			
			int moveSets[][][] = new int[][][] {directionArray};
			
			System.out.println(directionMoves.size());
			
			directionMoves.forEach(item -> {
				System.out.println(directionMoves.indexOf(item));
				//System.out.println(item[0]+','+item[1]);
			});
			
			possibleMoves.add(moveSets);
		}
		
		return possibleMoves;
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