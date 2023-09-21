// For some arbitrary game state of a checkers game, return all possible next moves.
// Example state of a checkers board:
//  0             7
// |██X ██X ██X ██X |row 0
// |X ██X ██X ██X ██|
// |██X ██X ██X ██X |
// |  ██  ██  ██  ██|
// |██  ██  ██  ██  |
// |Y ██Y ██Y ██Y ██|row 5
// |██Y ██Y ██Y ██Y |
// |Y ██Y ██Y ██Y ██|

// Pieces can only move 1 space diagonally towards their forward direction. "X" pieces must move downwards, and "O"
// pieces must move upwards.
// Cannot move into an occupied space or off the board.

// We want to create a function that takes in “the state of the game”, and returns the set of possible “moves” the
// current player could make.
// How you represent the state of the game and how you  represent a move is completely up to you.

/*
 * Click `Run` to execute the snippet below!
 */

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class Checkers {
    private static final int MAX_ROWS = 4;

    public static void main(String[] args) {

        /**      col0   col1  col2  col3
         * row0  null, null, null, null
         * row1  null, null,  null,  O
         * row2  null, null,  X,   null
         * row3  null, null, null,  O
         */
        Checker[][] board = new Checker[4][4];
        board[1][3] = new Checker("O", 1, 3);
        board[3][3] = new Checker("O", 3, 3);
        board[2][2] = new Checker("X", 2, 2);

        //printBoard(board);
        String player = "O";
        System.out.println("Plays: " + player);
        for (Move m : getAllMovesByPlayer(player, board)) {
            System.out.println(m.toString());
        }
    }

    private static List<Move> getAllMovesByPlayer(String playerLabel, Checker[][] board) {
        List<Move> result = new ArrayList<>();
        for (int i = 0; i < MAX_ROWS; i++) {
            for (int j = 0; j < MAX_ROWS; j++) {
                if (board[i][j] != null && board[i][j].getLabel().equals(playerLabel)) {
                    result.addAll(getAllMovesByChecker(board[i][j], board));
                }
            }
        }
        if (result.isEmpty()) System.out.println("No valid moves");
        return result;
    }

    private static List<Move> getAllMovesByChecker(Checker c, Checker[][] board) {
        List<Move> result;

        int direction = c.label.equalsIgnoreCase("O") ? -1 : 1;
        result = getNewMoves(c, direction, board);
        return result;
    }

    private static List<Move> getNewMoves(Checker c, int direction, Checker[][] board) {
        List<Move> result;
        int rightCol;
        int leftCol;
        int newRow;
        // to explore if capture is possible
        int nextRightCol;
        int nextLeftCol;
        int nextNewRow;

        rightCol = c.getCol() + 1;
        nextRightCol = rightCol + 1;
        leftCol = c.getCol() - 1;
        nextLeftCol = leftCol - 1;
        if (direction < 0) {
            newRow = c.getRow() - 1;
            nextNewRow = newRow - 1;
        } else {
            newRow = c.getRow() + 1;
            nextNewRow = newRow + 1;
        }

        // check left
        result = checkLeftAndRightMoves(newRow, leftCol, c, nextNewRow, nextLeftCol, board);

        // check right
        result.addAll(checkLeftAndRightMoves(newRow, rightCol, c, nextNewRow, nextRightCol, board));

        return result;
    }

    private static List<Move> checkLeftAndRightMoves(
            int row,
            int col,
            Checker c,
            int nextRow,
            int nextCol,
            Checker[][] board
    ) {
        List<Move> result = new ArrayList<>();
        if (row >= 0 && row < MAX_ROWS && col >= 0 && col < MAX_ROWS) if (board[row][col] == null) {
            result.add(new Move(c.getRow(), c.getCol(), row, col, "A"));
        } else {
            if (!board[row][col].getLabel().equalsIgnoreCase(c.getLabel())) {
                if (nextRow >= 0 && nextRow < MAX_ROWS && nextCol >= 0 && nextCol < MAX_ROWS &&
                        board[nextRow][nextCol] == null) {
                    result.add(new Move(c.getRow(), c.getCol(), nextRow, nextCol, "C"));
                }
            }
        }
        return result;
    }

    private static void printBoard(Checker[][] board) {
        Checker c = new Checker();
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                c = board[i][j];
                if (c == null) System.out.println(i + "," + j + "= empty");
                else System.out.println(i + "," + j + "= " + c.label);
            }
        }
        System.out.println("---");
    }

    private static class Checker {
        String label;  // X or Y
        int row;
        int col;

        public Checker() {
        }

        public Checker(String label, int row, int col) {
            this.label = label;
            this.row = row;
            this.col = col;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }
    }

    private static class Move {
        int startX;
        int startY;
        int endX;
        int endY;
        String type; // A: single advance, C: capture

        public Move() {
        }

        public Move(int startX, int startY, int endX, int endY, String type) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
            this.type = type;

        }

        public int getStartX() {
            return startX;
        }

        public void setStartX(int startX) {
            this.startX = startX;
        }

        public int getStartY() {
            return startY;
        }

        public void setStartY(int startY) {
            this.startY = startY;
        }

        public int getEndX() {
            return endX;
        }

        public void setEndX(int endX) {
            this.endX = endX;
        }

        public int getEndY() {
            return endY;
        }

        public void setEndY(int endY) {
            this.endY = endY;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String toString() {
            return "From: (" + this.startX + "," + this.startY + ")" + " To: (" + this.endX + "," + this.endY + ") " +
                    "Type: " + this.type;

        }
    }


}
