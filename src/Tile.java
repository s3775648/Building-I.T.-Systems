import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tile extends JPanel {
	
	//When !clicked
	private Color lightTileColour = new Color(255, 255, 102);
	private Color darkTileColour = new Color(153, 76, 0);
	
	//When clicked
	private Color lightTileColourSelected = new Color(255, 255, 51);
	private Color darkTileColourSelected = new Color(204, 102, 0);
	
	private boolean isWhite; //Piece
	private boolean isLightTile; //Tile
	private boolean selected = false;
	Piece piece;
	
	private final int indexX;
	private final int indexY;
	
	public Tile(int colour, int indexY, int indexX, int startPiece, boolean isWhite) {
		super();
		this.isWhite = isWhite;
		this.indexX = indexX;
		this.indexY = indexY;
		createPiece(startPiece);
		if(colour == 1) {
			isLightTile = true;
		} else {
			isLightTile = false;
		}
		//System.out.println("Created tile.");
	}
	
	public boolean isWhite() {
		if(this.isWhite) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getIndexX() {
		return indexX;
	}
	
	public int getIndexY() {
		return indexY;
	}
	
	public BufferedImage getPieceImage() throws IOException {
		return getPiece().pieceImage();
	}
	
	public Piece getPiece() {
		return this.piece;
	}
	
	public boolean isLightTile() {
		if(this.isLightTile) {
			return true;
		} else {
			return false;
		}
	}
	
	public void setSelected(boolean i) {
		selected = i;
		this.repaint();
	}
	public boolean isSelected() {
		if(selected) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(isLightTile()) {
			if(isSelected()) {
				g.setColor(lightTileColourSelected);
			} else {
				g.setColor(lightTileColour);
			}
		} else {
			if(isSelected()) {
				g.setColor(darkTileColourSelected);
			} else {
				g.setColor(darkTileColour);
			}
		}
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		if(getPiece() != null) {
			try {
				g.drawImage(getPieceImage(), 0, 0, this.getWidth(), this.getHeight(), null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private void createPiece(int pieceNumber) {
		switch(pieceNumber) {
		case 0: 
			return;
		case 1:
			setPiece(new Pawn(isWhite()));
			break;
		case 2:
			setPiece(new Rook(isWhite()));
			break;
		case 3:
			setPiece(new Bishop(isWhite()));
			break;
		case 4:
			setPiece(new Knight(isWhite()));
			break;
		case 5:
			setPiece(new Queen(isWhite()));
			break;
		case 6:
			setPiece(new King(isWhite()));
			break;
		default:
			System.out.println("ERROR");
		}
	}
	
	private void setPiece(Piece i) {
		this.piece = i;
	}
}
