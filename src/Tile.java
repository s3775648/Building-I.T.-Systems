import javax.swing.JPanel;

public class Tile extends JPanel {
	
	Piece piece;
	public Tile(int colour, int indexY, int indexX, int startPiece, boolean isWhite) {
		super();
		createPiece(startPiece);
	}
	
	private void createPiece(int pieceNumber) {
		switch(pieceNumber) {
		case 0: 
			return;
		case 1:
			setPiece(new Pawn());
		}
	}
	
	private void setPiece(Piece i) {
		this.piece = i;
	}
}
