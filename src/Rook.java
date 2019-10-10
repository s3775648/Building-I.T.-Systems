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

}
