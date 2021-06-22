import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ybchen
 * @Date: 2021/6/22 8:45
 */
public class Code89GrayCode {
    /**
     * @param n
     * @return
     */
    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            int num = i ^ (i / 2);
            result.add(num);
        }
        return result;

    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(grayCode(n));
    }
}
