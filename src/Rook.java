import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Rook extends Piece
{
    public Rook(boolean isWhite)
    {
        super(isWhite);
    }

    @Override
    public int[][] canMove()
    {
        int[][] moves = new int[][]{
                {1,0}, {2,0}, {3,0}, {4,0}, {5,0}, {6,0}, {7,0},         //North
                {-1,0}, {-2,0}, {-3,0}, {-4,0}, {-5,0}, {-6,0}, {-7,0},  //South
                {0,1}, {0,2}, {0,3}, {0,4}, {0,5}, {0,6}, {0,7},         // East
                {0,-1}, {0,-2}, {0,-3}, {0,-4}, {0,-5}, {0,-6}, {0,-7}}; // West
        return moves;
    }

    @Override
    public BufferedImage pieceImage() throws IOException
    {
        BufferedImage image;
        if (isWhite())
        {
            image = ImageIO.read(new File("WhiteRook.png"));
            return image;
        }
        else
        {
            image = ImageIO.read(new File("BlackRook.png"));
            return image;
        }
    }
}
