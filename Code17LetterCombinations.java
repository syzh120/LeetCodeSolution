import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ybchen
 * @Date: 2020/11/11 11:21
 */
public class Code17LetterCombinations {


    /**
     *给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意0和1 不对应任何字母。
     *
     *
     *
     * 示例:
     *
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * 说明:
     * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param digits
     * @return
     */

    public static List<String> letterCombinations(String digits) {
        List<String> resList=new ArrayList<>();
        if(digits==null||digits.length()==0) return resList;
        int len=digits.length();
        char[] chs=digits.toCharArray();
        final String [] arr={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuffer path=new StringBuffer();
        process(chs,resList,arr,path,len);
        return resList;

    }

    static void process(char[] digits, List<String> resList, String[] arr, StringBuffer path, int length) {
        if (path.length() >= length) {
            resList.add(path.toString());
            return;
        }
        for (int i = 0; i < arr[digits[path.length()]  - '0'].length(); i++) {
            path.append(arr[digits[path.length()] - '0'].charAt(i));
            process(digits, resList, arr, path  , length);
            path.deleteCharAt(path.length()-1);
        }
    }

     static void main(String[] args) {
        String digits="22";
        System.out.println(letterCombinations(digits));
    }



}
