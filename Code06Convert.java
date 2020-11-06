/**
 * @Author: ybchen
 * @Date: 2020/11/6 14:48
 */
public class Code06Convert{

    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     *
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zigzag-conversion
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        numRows = Math.min(s.length(), numRows);
        if(numRows==1) return s;
        StringBuffer[] buffers = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            buffers[i] = new StringBuffer();
        }
        char[] chs=s.toCharArray();
        boolean goingDown=true;
        for (int curRow = 0,index=0; curRow < numRows && index < s.length();) {
            buffers[curRow].append(chs[index++]);
            if (curRow == numRows - 1) goingDown = false;
            if (curRow == 0) goingDown = true;
            curRow = goingDown ? curRow + 1 : curRow - 1;
        }
        StringBuffer sb = new StringBuffer();
        for (StringBuffer buffer : buffers) {
            sb.append(buffer);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s="LEETCODEISHIRING";
        s=convert(s,3);
        System.out.println(s);
    }
}
