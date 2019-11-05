import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class King extends Piece {
    private boolean hasCastled;

    public King(boolean isWhite) {
        super(isWhite, "King");
        this.hasCastled = false;
    }

    public boolean hasCastled() {
        return hasCastled;
    }

    public void setHasCastled(boolean hasCastled) {
        this.hasCastled = hasCastled;
    }

    @Override
    public int[][][] canMove() {
        int[][][] moves;
        moves = new int[][][] {
                {{1,0}},       // South
                {{-1,0}},      // North
                {{0,1}},       // East
                {{0,-1}},      // West
                {{1,1}},       // South-East
                {{1,-1}},      // South-West
                {{-1,1}},      // North-East
                {{-1,-1}}      // North-West
        };
        return moves;
    }

    @Override
    public BufferedImage pieceImage() throws IOException {
        BufferedImage image;
        if (isWhite()) {
            image = ImageIO.read(getClass().getResource("Pieces/Final Pieces/White set/WhiteKing.png"));
            return image;
        } else {
            image = ImageIO.read(getClass().getResource("Pieces/Final Pieces/Black set/BlackKing.png"));
            return image;
        }
    }
}
