import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Snake extends Piece {

    public Snake(boolean isWhite) {
        super(isWhite, "Snake");
    }

    @Override
    public int[][][] canMove() {
        int[][][] moves = new int[][][] {
        	{{1,1}, {1,3}, {3,1}, {3,3}}, 		//North East
        	{{1,-1}, {1,-3}, {3,-1}, {3,-3}}, 	//North West
        	{{-1,1}, {-1,3}, {-3,1}, {-3,3}}, 	//South East
        	{{-1,-1}, {-1,-3}, {-3,-1}, {-3,-3}} // South West
        };
        return moves;
    }

    @Override
    public BufferedImage pieceImage() throws IOException {
        BufferedImage image;
        if (isWhite()) {
            image = ImageIO.read(getClass().getResource("Pieces/Final Pieces/White set/Whitesnake.png"));
            return image;

        } else {
            image = ImageIO.read(getClass().getResource("Pieces/Final Pieces/Black set/Blacksnake.png"));
            return image;
        }
    }
}
