/**
 * @Author: ybchen
 * @Date: 2020/12/24 16:01
 */
public class Code79WordSearch {
    //上 下 左 右
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word, boolean[][] visited, int curRow, int curCol, int curIndex) {
        if (curIndex >= word.length()) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            if (isNotInArea(board, curRow, curCol) || word.charAt(curIndex) != board[curRow][curCol] || visited[curRow][curCol]) {
                return false;
            } else {
                visited[curRow][curCol] = true;
                if (dfs(board, word, visited, curRow + dx[i], curCol + dy[i], curIndex + 1)) {
                    return true;
                }
                visited[curRow][curCol] = false;
            }
        }
        return false;
    }

    //是否为合法区
    public static boolean isNotInArea(char[][] board, int row, int column) {
        return row < 0 || row >= board.length || column < 0 || column >= board[0].length;
    }


    public static void main(String[] args) {
        //
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
}
