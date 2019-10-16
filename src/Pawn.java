import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Pawn extends Piece
{
    private boolean isFirstMove;

    public Pawn(boolean isWhite)
    {
        super(isWhite);
        isFirstMove = true;
    }

    @Override
    public int[][] canMove()
    {
        int[][] moves;
        if (isFirstMove && isWhite())
        {
            moves = new int[][]
                    {{1,0}, {2,0}};
            return moves;
        }
        else if (isFirstMove && !isWhite())
        {
            moves = new int[][]
                    {{-1,0}, {-2,0}};
            return moves;
        }
        else if (isWhite())
        {
            moves = new int[][]
                    {{1,0}};
            return moves;
        }
        else
        {
            moves = new int[][]
                    {{-1,0}};
            return moves;
        }
    }

    @Override
    public BufferedImage pieceImage() throws IOException
    {
        BufferedImage image;
        if (isWhite())
        {
            image = ImageIO.read(new File("WhitePawn.png"));
            return image;
        }
        else
        {
            image = ImageIO.read(getClass().getResource("Pieces/Final Pieces/Black Set/BlackPawn.png"));
            return image;
        }
    }
}
