import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ybchen
 * @Date: 2021/8/16 16:25
 */
public class Code241DiffWaysToCompute {

    public static List<Integer> diffWaysToCompute(String expression) {

        return process(expression, 0, expression.length() - 1);
    }


    public static List<Integer> operatorIndexList(String expression, int startIndex, int endIndex) {
        List<Integer> result = new ArrayList<>();
        for (int i = startIndex; i <= endIndex; i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '/') {
                result.add(i);
            }
        }
        return result;
    }

    public static List<Integer> process(String expression, int startIndex, int endIndex) {
        List<Integer> resultList = new ArrayList<>();
        List<Integer> operatorList = operatorIndexList(expression, startIndex, endIndex);
        if (operatorList.isEmpty()) {
            //没有运算符号
            resultList.add(noOperatorCase(expression, startIndex, endIndex));
            return resultList;
        }
        for (int i : operatorList) {
            List<Integer> leftListResult = process(expression, startIndex, i - 1);
            List<Integer> rightListResult = process(expression, i + 1, endIndex);
            mergeList(leftListResult, rightListResult, resultList, expression.charAt(i));
        }
        return resultList;
    }

    /**
     * 没有字符串的case
     *
     * @param expression
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static int noOperatorCase(String expression, int startIndex, int endIndex) {
        int sum = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            sum = sum * 10 + (expression.charAt(i) - '0');
        }
        return sum;
    }

    /**
     * 归并两个字符串
     *
     * @param leftListResult
     * @param rightListResult
     * @param operator
     * @return
     */
    public static void mergeList(List<Integer> leftListResult, List<Integer> rightListResult, List<Integer> resultList, char operator) {
        if (operator == '+') {
            mergeListforAdd(leftListResult, rightListResult, resultList);
        } else if (operator == '-') {
            mergeListforMinus(leftListResult, rightListResult, resultList);
        } else if (operator == '*') {
            mergeListforMultiply(leftListResult, rightListResult, resultList);
        } else {
            mergeListforDivide(leftListResult, rightListResult, resultList);
        }

    }


    public static void mergeListforMultiply(List<Integer> leftListResult, List<Integer> rightListResult, List<Integer> resultList) {
        for (Integer num1 : leftListResult) {
            for (Integer num2 : rightListResult) {
                resultList.add(num1 * num2);
            }
        }
    }

    public static void mergeListforDivide(List<Integer> leftListResult, List<Integer> rightListResult, List<Integer> resultList) {
        for (Integer num1 : leftListResult) {
            for (Integer num2 : rightListResult) {
                resultList.add(num1 / num2);
            }
        }
    }

    public static void mergeListforAdd(List<Integer> leftListResult, List<Integer> rightListResult, List<Integer> resultList) {
        for (Integer num1 : leftListResult) {
            for (Integer num2 : rightListResult) {
                resultList.add(num1 + num2);
            }
        }
    }

    public static void mergeListforMinus(List<Integer> leftListResult, List<Integer> rightListResult, List<Integer> resultList) {
        for (Integer num1 : leftListResult) {
            for (Integer num2 : rightListResult) {
                resultList.add(num1 - num2);
            }
        }
    }

    public static void main(String[] args) {
        String s = "2*3-4*5";
        System.out.print(diffWaysToCompute(s));
    }
}
