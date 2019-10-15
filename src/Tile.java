import java.awt.Graphics;

import javax.swing.JPanel;

public class Tile extends JPanel {
	
	private boolean isWhite;
	Piece piece;
	
	public Tile(int colour, int indexY, int indexX, int startPiece, boolean isWhite) {
		super();
		this.isWhite = isWhite;
		createPiece(startPiece);
	}
	
	public boolean isWhite() {
		if(this.isWhite) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
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
