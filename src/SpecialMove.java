import java.util.Scanner;

public class SpecialMove {

    public static Scanner scanner = new Scanner(System.in);

    public static int pawnEvolution(Pawn pawn, Game game) {
        int result = checkPawnEvolution(pawn, game);
        int selection = 0;
        if (result == 1 || result == 2) {
            while (selection < 1 || selection > 5) {
                System.out.println("Pawn Evolution Legal \n" +
                        "1 - Pawn\n" +
                        "2 - Rook\n" +
                        "3 - Knight\n" +
                        "4 - Bishop\n" +
                        "5 - Queen\n");
                selection = scanner.nextInt();
                scanner.nextLine();
            }
        }

        return selection;
    }

    private static int checkPawnEvolution(Pawn pawn, Game game) {

        int[][] piecePosition = game.getPieceNumbers();

        // White Pawn evolution
        if (pawn.isWhite() && (piecePosition[0][0] == 1 ||
                piecePosition[0][1] == 1 ||
                piecePosition[0][2] == 1 ||
                piecePosition[0][3] == 1 ||
                piecePosition[0][4] == 1 ||
                piecePosition[0][5] == 1 ||
                piecePosition[0][6] == 1 ||
                piecePosition[0][7] == 1)) {
            return 1;
        }
        else if (!pawn.isWhite() && (piecePosition[7][0] == 1 ||
                piecePosition[7][1] == 1 ||
                piecePosition[7][2] == 1 ||
                piecePosition[7][3] == 1 ||
                piecePosition[7][4] == 1 ||
                piecePosition[7][5] == 1 ||
                piecePosition[7][6] == 1 ||
                piecePosition[7][7] == 1)) {
            return 2;
        }
        else {
            return 0;
        }
    }

    public static Object[] castle(King king, Rook rook, Game game) throws IllegalCastlingException {
        int result = checkCastlingLegal(king, rook, game);
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
        else if (result == 0) {
            throw new IllegalCastlingException("Castling move illegal");
        }
        return castlingMovements;    
    }

    private static int checkCastlingLegal(King king, Rook rook, Game game) {

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

    private static class IllegalCastlingException extends Exception {
        public IllegalCastlingException(String errorMessage) {
            super(errorMessage);
        }
    }
}
