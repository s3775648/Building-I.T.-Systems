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
        int[][] move;
        if (isFirstMove && isWhite())
        {
            move = new int[][]
                    {
                            {1, 0},
                            {2, 0}};

            return move;
        }
        else if (isFirstMove && !isWhite())
        {
            move = new int[][]
                    {
                            {-1,0},
                            {-2,0}};
            return move;
        }
        else if (isWhite())
        {
            move = new int[][]
                    {{1,0}};
            return move;
        }
        else
        {
            move = new int[][]
                    {{-1,0}};
            return move;
        }
    }
}
