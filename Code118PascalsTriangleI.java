import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ybchen
 * @Date: 2021/8/16 14:49
 */
public class Code118PascalsTriangleI {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        //init state
        List<Integer> list = new ArrayList<>(1);
        list.add(1);
        result.add(list);
        //calculate next rows
        for (int i = 1; i < numRows; i++) {
            List<Integer> preRow = result.get(i - 1);
            List<Integer> subList = new ArrayList<>();
            subList.add(1);
            for (int j = 1; j < i; j++) {
                int temp = preRow.get(j) + preRow.get(j - 1);
                subList.add(temp);
            }
            subList.add(1);
            result.add(subList);
        }

        return result;
    }

    public static void main(String[] args) {
        //
    }
}
