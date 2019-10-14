public class Bishop extends Piece
{
    public Bishop(boolean isWhite)
    {
        super(isWhite);
    }

    @Override
    public int[][] canMove()
    {
        int[][] moves = new int[][]{
                {1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}, {7, 7}, // North-East
                {1, -1}, {2, -2}, {3, -3}, {4, -4}, {5, -5}, {6, -6}, {7, -7}, // North-West
                {-1, 1}, {-2, 2}, {-3, 3}, {-4, 4}, {-5, 5}, {-6, 6}, {-7, 7}, // South-East
                {-1, -1}, {-2, -2}, {-3, -3}, {-4, -4}, {-5, -5}, {-6, -6}, {-7, -7} // South-West
        };
        return moves;
    }
}
