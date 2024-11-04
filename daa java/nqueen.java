import java.util.Scanner;

public class NQueens {

    private static void printSolution(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean cell : row) System.out.print(cell ? "Q " : ". ");
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        for (int i = 0; i < row; i++) if (board[i][col]) return false;
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) if (board[i][j]) return false;
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) if (board[i][j]) return false;
        return true;
    }

    private static void solve(boolean[][] board, int row) {
        if (row == board.length) {
            printSolution(board);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                solve(board, row + 1);
                board[row][col] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of queens: ");
        int n = scanner.nextInt();
        solve(new boolean[n][n], 0);
    }
}
