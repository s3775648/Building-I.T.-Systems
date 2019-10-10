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
}
