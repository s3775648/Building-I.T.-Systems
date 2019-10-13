import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Board extends JPanel {
	private final int tiles_x;
	private final int tiles_y;
	private final int tile_width;
	private final int tile_height;
	private final int[][] tileSpotArray;
	private Tile[][] tilesArray;
	
	public Board(int tiles_x, int tiles_y, int tile_width, int tile_height, int[][] tiles) {
		super();
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
				//Determine if tile is white, black, a space (Would be an added feature)
				//Determined via the integer in the array, 1 = white, 0 = black, 2 = space
				Tile i = new Tile(tiles[y][x], y, x);
				add(i);
				tilesArray[y][x] = i;
				
			}
		}
	}
}
