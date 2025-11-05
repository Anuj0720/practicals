public class DAA5NQueen {
    static int N = 5;           // change N if you want
    static int[][] board;

    static boolean isSafe(int row, int col) {
        for (int c = 0; c < col; c++) if (board[row][c] == 1) return false;
        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) if (board[r][c] == 1) return false;
        for (int r = row, c = col; r < N && c >= 0; r++, c--) if (board[r][c] == 1) return false;
        return true;
    }

    static boolean solveFromCol(int col) {
        if (col >= N) return true;
        boolean alreadyPlaced = false;
        for (int r = 0; r < N; r++) if (board[r][col] == 1) { alreadyPlaced = true; break; }
        if (alreadyPlaced) return solveFromCol(col + 1);
        for (int r = 0; r < N; r++) {
            if (isSafe(r, col)) {
                board[r][col] = 1;
                if (solveFromCol(col + 1)) return true;
                board[r][col] = 0;
            }
        }
        return false;
    }

    static void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        board = new int[N][N];

        int fixedRow = 0; 
        board[fixedRow][0] = 1;
        if (solveFromCol(0)) {
            System.out.println("Solution with first queen at (row " + fixedRow + ", col 0):");
            printBoard();
        } else {
            System.out.println("No solution with first queen at (row " + fixedRow + ", col 0).");
        }

        System.out.println("\nTrying all initial rows in column 0:");
        boolean found = false;
        for (int r = 0; r < N; r++) {
            for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) board[i][j] = 0;
            board[r][0] = 1;
            if (solveFromCol(0)) {
                System.out.println("Works when first queen is at row " + r + ":");
                printBoard();
                found = true;
                break;
            }
        }
        if (!found) System.out.println("No initial row in column 0 yields a solution for N = " + N);
    }
}
