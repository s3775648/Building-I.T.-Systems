public class Knight extends Piece
{
    public Knight(boolean isWhite)
    {
        super(isWhite);
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
}
