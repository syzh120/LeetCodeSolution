import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ybchen
 * @Date: 2021/8/16 15:16
 */
public class Code119PascalsTriangleII {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> preList = new ArrayList<>(1);
        preList.add(1);
        List<Integer> curList = new ArrayList<>();
        int i;
        for (i = 1; i <= rowIndex; i++) {
            curList.add(1);
            for (int j = 1; j < i; j++) {
                curList.add(preList.get(j - 1) + preList.get(j));
            }
            curList.add(1);
            preList = curList;
            curList = new ArrayList<>();
        }

        return preList;
    }

    public static void main(String[] args) {
        //
        int rowIndex = 0;
        System.out.println(getRow(rowIndex));
    }
}
