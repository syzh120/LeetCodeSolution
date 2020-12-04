/**
 * @Author: ybchen
 * @Date: 2020/12/4 11:03
 */
public class Code36ValidSudoku {

    /**
     *
     * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
     * Each row must contain the digits 1-9 without repetition.
     * Each column must contain the digits 1-9 without repetition.
     * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     * Note:
     * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
     * Only the filled cells need to be validated according to the mentioned rules.
     * @param board
     * @return
     */

    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] subBox = new boolean[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if(row[i][board[i][j] - '1']|| col[j][board[i][j] - '1']|| subBox[3*(i/3)+j/3][board[i][j]-'1']){
                    return false;
                }
                row[i][board[i][j] - '1'] = true;
                col[j][board[i][j] - '1'] = true;
                subBox[3*(i/3)+j/3][board[i][j]-'1'] = true;

            }


        }

        return true;
    }

}
