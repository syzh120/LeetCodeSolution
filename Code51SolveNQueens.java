import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ybchen
 * @Date: 2020/12/29 14:29
 */
public class Code51SolveNQueens {

    /**
     * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two
     * queens attack each other.
     *
     * <p>Given an integer n, return all distinct solutions to the n-queens puzzle.
     *
     * <p>Each solution contains a distinct board configuration of the n-queens' placement, where 'Q'
     * and '.' both indicate a queen and an empty space, respectively.
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        int totalRow = n;
        int curRow = 0;
        List<Integer> queueList = new ArrayList<>();
        List<List<String>> resList = new ArrayList<>();
        char[][] board = generateBoard(n);
        process(totalRow, curRow, queueList, resList, board);
        return resList;
    }


    public static void process(int totalRow, int curRow, List<Integer> queueList, List<List<String>> resList, char[][] board) {
        if (curRow >= totalRow) {
            resList.add(intList2StrList(board));
        }
        for (int curColumn = 0; curColumn < totalRow; curColumn++) {
            if (!canPlaceQueue(queueList, curRow, curColumn)) {
                continue;
            } else {
                board[curRow][curColumn] = 'Q';
                queueList.add(curColumn);
                process(totalRow, curRow + 1, queueList, resList, board);
                queueList.remove(queueList.size() - 1);
                board[curRow][curColumn] = '.';
            }

        }
        return;

    }

    public static boolean canPlaceQueue(List<Integer> queueList, int curRow, int curColumn) {
        for (int i = 0; i < queueList.size(); i++) {
            if (curColumn == queueList.get(i) || Math.abs(curColumn - queueList.get(i)) == Math.abs(curRow - i)) {
                return false;
            }
        }
        return true;
    }

    public static List<String> intList2StrList(char[][] board) {
        List<String> stringList = new ArrayList<>();
        int boardSize = board.length;
        for (int row = 0; row < boardSize; row++) {
            stringList.add(new String(board[row]));
        }
        return stringList;
    }


    public char[][] generateBoard(int boardSize) {
        char[][] board = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            Arrays.fill(board[i], '.');
        }
        return board;

    }

}
