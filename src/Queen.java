import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Queen extends Piece {

    public Queen(boolean isWhite) {
        super(isWhite, "Queen");
    }

    @Override
    public int[][] canMove() {
        int[][] moves = new int[][] {
                {1,0}, {2,0}, {3,0}, {4,0}, {5,0}, {6,0}, {7,0}, // South
                {-1,0}, {-2,0}, {-3,0}, {-4,0}, {-5,0}, {-6,0}, {-7,0}, // North
                {0,1},{0,2},{0,3},{0,4},{0,5},{0,6},{0,7}, // East
                {0,-1},{0,-2},{0,-3},{0,-4},{0,-5},{0,-6},{0,-7}, // West
                {1,1}, {2,2}, {3,3}, {4,4}, {5,5}, {6,6}, {7,7}, // South-East
                {1,-1}, {2,-2}, {3,-3}, {4,-4}, {5,-5}, {6,-6}, {7,-7}, // South-West
                {-1,1}, {-2,2}, {-3,3}, {-4,4}, {-5,5}, {-6,6}, {-7,7}, // North-East
                {-1,-1}, {-2,-2}, {-3,-3}, {-4,-4}, {-5,-5}, {-6,-6}, {-7,-7} // North-West
        };
        return moves;
    }

    @Override
    public BufferedImage pieceImage() throws IOException {
        BufferedImage image;
        if (isWhite()) {
            image = ImageIO.read(getClass().getResource("Pieces/Final Pieces/White set/WhiteQueen.png"));
            return image;

        } else {
            image = ImageIO.read(getClass().getResource("Pieces/Final Pieces/Black set/BlackQueen.png"));
            return image;
        }
    }
}
