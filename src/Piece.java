import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Abstract class to represent common functionality of all chess pieces.
 */
public abstract class Piece {
    private boolean isKilled;
    private boolean isWhite;
    private int movementCounter, killStreak;
    private String pieceName;

    public Piece(boolean isWhite, String pieceName, int indexX, int indexY) {
        this.isWhite = isWhite;
        this.isKilled = false;
        this.movementCounter = 0;
        this.killStreak = 0;
        this.pieceName = pieceName;
    }

    /**
     * [x][y] board coordinates.
     * @return, possible moves.
     */
    public abstract int[][][] canMove();

    public abstract BufferedImage pieceImage() throws IOException;

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public int getMovementCounter() {
        return movementCounter;
    }

    public int getKillStreak() {
        return killStreak;
    }

    public String getPieceName() {
        return pieceName;
    }

    public void setMovementCounter(int movementCounter) {
        this.movementCounter = movementCounter;
    }

    public void setKillStreak(int killStreak) {
        this.killStreak = killStreak;
    }
    
    // ADDED 06/11/2019 Manh 
    public Piece replacePiece(Piece replacedPiece) {
    	return replacedPiece;
    }

    public boolean removePiece() {
    	return true;
    }
    
    public Piece setPiece(Piece i) {
    	return i;
    }
}
