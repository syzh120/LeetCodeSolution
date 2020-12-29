import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ybchen
 * @Date: 2020/12/29 13:41
 */
public class Code52TotalNQueens {


    public static int totalNQueens(int n) {

        List<Integer> queueList = new ArrayList<>();
        return process(n, 0, queueList);

    }

    /**
     * 放置皇后
     *
     * @param totalRow
     * @param curRow
     * @param queueList
     * @return
     */

    public static int process(int totalRow, int curRow, List<Integer> queueList) {
        if (curRow >= totalRow) {
            return 1;
        }
        int result = 0;
        for (int curColumn = 0; curColumn < totalRow; curColumn++) {
            if (!canPlaceQueue(queueList, curRow, curColumn)) {
                continue;
            } else {
                queueList.add(curColumn);
                result += process(totalRow, curRow + 1, queueList);
                queueList.remove(queueList.size() - 1);
            }

        }
        return result;

    }

    public static boolean canPlaceQueue(List<Integer> queueList, int curRow, int curColumn) {
        for (int i = 0; i < queueList.size(); i++) {
            if (curColumn == queueList.get(i) || Math.abs(curColumn - queueList.get(i)) == Math.abs(curRow - i)) {
                return false;
            }
        }
        return true;
    }


}
