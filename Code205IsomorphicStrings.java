import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ybchen
 * @Date: 2021/2/23 17:14
 */
public class Code205IsomorphicStrings {

    //TODO 尝试不用map解决此问题
    public boolean process(String s, String t) {
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < chs.length; i++) {
            if (!map.containsKey(chs[i])) {
                map.put(chs[i], cht[i]);
            } else {
                if (map.get(chs[i]) != cht[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        return process(s, t) && process(t, s);
    }
}
