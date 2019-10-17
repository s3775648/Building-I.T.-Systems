import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Knight extends Piece
{
    public Knight(boolean isWhite)
    {
        super(isWhite, "Knight");
    }

    @Override
    public int[][] canMove()
    {
        int[][] moves = new int[][] {
                {1,-2}, // North-West 1
                {2,-1}, // North-West 2
                {2,1},  // North-East 1
                {1,2},  // North-East 2
                {-1,-2},// South-West 1
                {-2,-1},// South-West 2
                {-2,1}, // South-East 1
                {-1,2}, // South-East 2
        };
        return moves;
    }

    @Override
    public BufferedImage pieceImage() throws IOException
    {
        BufferedImage image;
        if (isWhite())
        {
            image = ImageIO.read(getClass().getResource("Pieces/Final Pieces/White set/WhiteKnight.png"));
            return image;
        }
        else
        {
            image = ImageIO.read(getClass().getResource("Pieces/Final Pieces/Black set/BlackKnight.png"));
            return image;
        }
    }
}
