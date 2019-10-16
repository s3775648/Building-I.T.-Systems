import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JPanel;

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
	
	public Tile(int colour, int indexY, int indexX, int startPiece, boolean isWhite) {
		super();
		this.isWhite = isWhite;
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
			//setPiece(new Castle());
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
