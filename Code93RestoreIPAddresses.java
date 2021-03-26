import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: ybchen
 * @Date: 2021/2/19 16:05
 */
public class Code93RestoreIPAddresses {


    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();
        process(s, result, path, 0);
        return result;

    }

    /**
     * this problem is similar with the subsets problem
     * which can solved by subsets split
     *
     * @param s
     * @param result
     * @param path
     * @param startIndex
     */
    public static void process(String s, List<String> result, Deque<String> path, int startIndex) {
        if (startIndex >= s.length() && path.size() == 4) {
            result.add(String.join(".", path));
            return;
        }
        if (s.length() - startIndex < 4 - path.size() || s.length() - startIndex > 3 * (4 - path.size())) {
            return;
        }
        for (int endIndex = startIndex; endIndex < startIndex + 3; endIndex++) {
            if (endIndex >= s.length()) {
                continue;
            }
            int candidateIp = judgeIpSegment(s, startIndex, endIndex);
            if (candidateIp < 0 || candidateIp > 255) {//which is not a valid ip address
                continue;
            } else {
                path.add(String.valueOf(candidateIp));
                process(s, result, path, endIndex + 1);
                path.removeLast();
            }

        }
    }

    /**
     * please make sure that end>=start
     *
     * @param s
     * @param start
     * @param end
     * @return
     */
    public static int judgeIpSegment(String s, int start, int end) {
        int result = 0;
        if (end - start + 1 > 1) {
            if (s.charAt(start) == '0') {
                return -1;
            }
            for (int i = start; i <= Math.min(s.length() - 1, end); i++) {
                result = 10 * result + (s.charAt(i) - '0');
            }
        } else {
            return s.charAt(start) - '0';
        }
        return result;
    }

    public static void main(String[] args) {
        //
        String s = "101023";
        List<String> result = restoreIpAddresses(s);
        for (String str : result) {
            System.out.println(str);
        }

    }
}
