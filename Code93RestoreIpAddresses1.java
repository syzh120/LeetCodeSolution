import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ybchen
 * @Date: 2021/12/31 9:17
 */
public class Code93RestoreIpAddresses1 {
    public static final int AMOUNT = 4;

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        process(s, result, path, 0);
        return result;
    }

    public static void process(String s, List<String> result, List<String> path, int startIndex) {
        if (startIndex >= s.length() && path.size() == AMOUNT) {
            result.add(String.join(".", path));
        } else if (startIndex >= s.length() || path.size() == AMOUNT) {
            return;
        }
        for (int splitIndex = startIndex; splitIndex < startIndex + 3; splitIndex++) {
            if (splitIndex >= s.length()) continue;
            String ipSegment = s.substring(startIndex, splitIndex + 1);
            if (!isValidIpSegment(ipSegment)) {
                continue;
            } else {
                path.add(ipSegment);
                process(s, result, path, splitIndex + 1);
                path.remove(path.size() - 1);
            }

        }

    }


    private static boolean isValidIpSegment(String s) {
        int len = s.length();

        // 大于 1 位的时候，不能以 0 开头
        if (len > 1 && s.charAt(0) == '0') {
            return false;
        }

        // 转成 int 类型
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = res * 10 + s.charAt(i) - '0';
        }

        return res <= 255;
    }

    public static void main(String[] args) {
        String s = "101023";
        System.out.print(restoreIpAddresses(s));
    }
}
