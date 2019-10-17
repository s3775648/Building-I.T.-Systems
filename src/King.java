import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class King extends Piece {
    private boolean hasCastled;

    public King(boolean isWhite) {
        super(isWhite, "King");
        this.hasCastled = false;
    }

    public boolean hasCastled() {
        return hasCastled;
    }

    public void setHasCastled(boolean hasCastled) {
        this.hasCastled = hasCastled;
    }

    @Override
    public int[][] canMove() {
        int[][] moves;
        moves = new int[][] {
                {1,0},       // North
                {-1,0},      // South
                {0,1},       // East
                {0,-1},      // West
                {1,1},       // North-East
                {1,-1},      // North-West
                {-1,1},      // South-East
                {-1,-1}};     // South-West
        return moves;
    }

    private int checkCastlingLegal(Rook rook) {
        Game game = new Game();
        int[][] piecePosition = game.getPieceNumbers();

        // Black King castling WEST
        if (!this.isWhite() &&
                getMovementCounter() == 0 &&
                !rook.isWhite() &&
                rook.getMovementCounter() == 0 &&
                piecePosition[0][2] == 0 &&
                piecePosition[0][1] == 0) {
            return 1;
        }
        // Black King castling EAST
        if (!this.isWhite() &&
                getMovementCounter() == 0 &&
                !rook.isWhite() &&
                rook.getMovementCounter() == 0 &&
                piecePosition[0][4] == 0 &&
                piecePosition[0][5] == 0 &&
                piecePosition[0][6] == 0) {
            return 2;
        }
        // White King castling WEST
        if (this.isWhite() &&
                getMovementCounter() == 0 &&
                rook.isWhite() &&
                rook.getMovementCounter() == 0 &&
                piecePosition[7][3] == 0 &&
                piecePosition[7][2] == 0 &&
                piecePosition[7][1] == 0) {
            return 3;
        }
        // White King castling EAST
        if (this.isWhite() &&
                getMovementCounter() == 0 &&
                rook.isWhite() &&
                rook.getMovementCounter() == 0 &&
                piecePosition[7][5] == 0 &&
                piecePosition[7][6] == 0) {
            return 4;
        }
        return 0;
    }


    @Override
    public BufferedImage pieceImage() throws IOException {
        BufferedImage image;
        if (isWhite()) {
            image = ImageIO.read(getClass().getResource("Pieces/Final Pieces/White set/WhiteKing.png"));
            return image;
        } else {
            image = ImageIO.read(getClass().getResource("Pieces/Final Pieces/Black set/BlackKing.png"));
            return image;
        }
    }
}
