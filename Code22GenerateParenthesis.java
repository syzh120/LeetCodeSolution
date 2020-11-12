import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ybchen
 * @Date: 2020/11/12 13:46
 */
public class Code22GenerateParenthesis {





    /**
     *
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

     * 示例：
     *
     * 输入：n = 3
     * 输出：[
     *        "((()))",
     *        "(()())",
     *        "(())()",
     *        "()(())",
     *        "()()()"
     *      ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/generate-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> resList = new ArrayList<>();
        if (n <= 0) {
            return resList;
        }
        StringBuffer sb = new StringBuffer();
        processVer1(resList, n, sb, 0, 0);
        return resList;
    }


    public static void processVer1(List<String> resList, int n, StringBuffer sb, int leftUsed, int rightUsed) {
        if (leftUsed == n && rightUsed == n) {
            resList.add(sb.toString());
            return;
        }

        if (rightUsed > leftUsed) {
            return;
        }
        if (rightUsed > n || leftUsed > n) {
            return;
        }

        processVer1(resList, n, sb.append('('), leftUsed+1, rightUsed);
        sb.deleteCharAt(sb.length() - 1);
        processVer1(resList, n, sb.append(')'), leftUsed, rightUsed + 1);
        sb.deleteCharAt(sb.length() - 1);
    }



    public static void processVer2(List<String> resList, int n, StringBuffer sb, int leftUsed, int rightUsed, char[] choices) {
        if (leftUsed == n && rightUsed == n) {
            resList.add(sb.toString());
            return;
        }
        for (int i = 0; i < choices.length; i++) {
            if (rightUsed > leftUsed) {
                continue;
            }
            if (rightUsed > n || leftUsed > n) {
                continue;
            }
            sb.append(choices[i]);
            if (choices[i] == '(') {
                processVer2(resList, n, sb, leftUsed + 1, rightUsed, choices);
            } else {
                processVer2(resList, n, sb, leftUsed, rightUsed + 1, choices);
            }
            sb.deleteCharAt(sb.length() - 1);

        }
        return;
    }

    public static void main(String[] args) {
        int n=2;
        List<String> res=generateParenthesis(n);
        System.out.println(res);
    }

}
