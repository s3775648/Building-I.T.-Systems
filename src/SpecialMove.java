public class SpecialMove {

    public static Object[] castle(King king, Rook rook) {
        int result = checkCastlingLegal(king, rook);
        int[][] kingMovement, rookMovement;
        Object[] castlingMovements = new Object[1];
        
        // Black King castling WEST
        if (result == 1) {
            kingMovement = new int[][] {{0,-2}};
            rookMovement = new int[][] {{0,2}};
            castlingMovements = new Object[] {kingMovement, rookMovement};
        }
        // Black King castling EAST
        else if (result == 2) {
            kingMovement = new int[][] {{0,3}};
            rookMovement = new int[][] {{0,-2}};
            castlingMovements = new Object[] {kingMovement, rookMovement};        
        }    
        // White King castling WEST
        else if (result == 3) {
            kingMovement = new int[][] {{0,-3}};
            rookMovement = new int[][] {{0,2}};
            castlingMovements = new Object[] {kingMovement, rookMovement};
        }
        // White King castling EAST
        else if (result == 4) {
            kingMovement = new int[][]{{0,2}};
            rookMovement = new int[][]{{0,-2}};
            castlingMovements = new Object[] {kingMovement, rookMovement};
        }
        return castlingMovements;    
    }

    private static int checkCastlingLegal(King king, Rook rook) {
        Game game = new Game();
        int[][] piecePosition = game.getPieceNumbers();

        // Black King castling WEST
        if (!king.isWhite() &&
                king.getMovementCounter() == 0 &&
                !rook.isWhite() &&
                rook.getMovementCounter() == 0 &&
                piecePosition[0][2] == 0 &&
                piecePosition[0][1] == 0) {
            return 1;
        }
        // Black King castling EAST
        if (!king.isWhite() &&
                king.getMovementCounter() == 0 &&
                !rook.isWhite() &&
                rook.getMovementCounter() == 0 &&
                piecePosition[0][4] == 0 &&
                piecePosition[0][5] == 0 &&
                piecePosition[0][6] == 0) {
            return 2;
        }
        // White King castling WEST
        if (king.isWhite() &&
                king.getMovementCounter() == 0 &&
                rook.isWhite() &&
                rook.getMovementCounter() == 0 &&
                piecePosition[7][3] == 0 &&
                piecePosition[7][2] == 0 &&
                piecePosition[7][1] == 0) {
            return 3;
        }
        // White King castling EAST
        if (king.isWhite() &&
                king.getMovementCounter() == 0 &&
                rook.isWhite() &&
                rook.getMovementCounter() == 0 &&
                piecePosition[7][5] == 0 &&
                piecePosition[7][6] == 0) {
            return 4;
        }
        return 0;
    }
}
