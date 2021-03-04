/**
 * @Author: ybchen
 * @Date: 2020/12/14 10:30
 */
public class Code37SolveSudoku {
    /**
     * Write a program to solve a Sudoku puzzle by filling the empty cells.
     *
     * <p>A sudoku solution must satisfy all of the following rules:
     *
     * <p>Each of the digits 1-9 must occur exactly once in each row. Each of the digits 1-9 must
     * occur exactly once in each column. Each of the digits 1-9 must occur exactly once in each of
     * the 9 3x3 sub-boxes of the grid. The '.' character indicates empty cells.
     *
     * @param board
     */
    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0, 9, 9);

    }

    public boolean dfs(char[][] board, int curRow, int curCol, int totalRow, int totalCol) {
        if (curRow >= totalRow) {
            return true;
        }
        if (board[curRow][curCol] == '.') {
            for (int i = 1; i <= 9; i++) {
                board[curRow][curCol] = (char) ('0' + i);
                if (!isValidSudoku(board)) {
                    board[curRow][curCol] = '.';
                    continue;
                }
                if (curCol == board[0].length - 1) {
                    if (dfs(board, curRow + 1, 0, totalRow, totalCol)) {
                        return true;
                    }
                } else {
                    if (dfs(board, curRow, curCol + 1, totalRow, totalCol)) {
                        return true;
                    }
                }
                board[curRow][curCol] = '.';
            }
        } else {
            if (curCol >= board.length - 1) {
                if (dfs(board, curRow + 1, 0, totalRow, totalCol)) {
                    return true;
                }
            } else {
                if (dfs(board, curRow, curCol + 1, totalRow, totalCol)) {
                    return true;
                }
            }

        }

        return false;
    }

    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] subBox = new boolean[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (row[i][board[i][j] - '1'] || col[j][board[i][j] - '1'] || subBox[3 * (i / 3) + j / 3][board[i][j] - '1']) {
                    return false;
                }
                row[i][board[i][j] - '1'] = true;
                col[j][board[i][j] - '1'] = true;
                subBox[3 * (i / 3) + j / 3][board[i][j] - '1'] = true;

            }


        }

        return true;
    }

}
