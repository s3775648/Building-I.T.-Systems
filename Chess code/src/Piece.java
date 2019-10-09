/**
 * Abstract class to represent common functionality of all chess pieces.
 */
public abstract class Piece
{
    private boolean isKilled;
    private boolean isWhite;

    public Piece(boolean isWhite)
    {
        this.isWhite = isWhite;
        this.isKilled = false;
    }

    public abstract int[][] canMove();

    public boolean isKilled()
    {
        return isKilled;
    }

    public void setKilled(boolean killed)
    {
        isKilled = killed;
    }

    public boolean isWhite()
    {
        return isWhite;
    }

    public void setWhite(boolean white)
    {
        isWhite = white;
    }
}
