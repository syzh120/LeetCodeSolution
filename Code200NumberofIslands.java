/**
 * @Author: ybchen
 * @Date: 2021/2/23 17:29
 */
public class Code200NumberofIslands {
    private final int[] dx = {1, -1, 0, 0};
    private final int[] dy = {0, 0, -1, +1};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    process(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    public void process(char[][] grid, boolean[][] visited, int curRow, int curCol) {
        visited[curRow][curCol] = true;
        for (int i = 0; i < 4; i++) {
            if (!isNeedMarked(grid, curRow + dx[i], curCol + dy[i], visited)) {
                continue;
            } else {
                process(grid, visited, curRow + dx[i], curCol + dy[i]);
            }
        }

    }

    public boolean isNeedMarked(char[][] grid, int curRow, int culCol, boolean[][] visited) {

        return !(curRow < 0 || curRow >= grid.length || culCol < 0 || culCol >= grid[0].length || visited[curRow][culCol] || grid[curRow][culCol] == '0');

    }


}
