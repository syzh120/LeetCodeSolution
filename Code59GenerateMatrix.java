/**
 * @Author: ybchen
 * @Date: 2020/12/28 16:16
 */
public class Code59GenerateMatrix {

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int sR = 0;
        int eR = n - 1;
        int sC = 0;
        int eC = n - 1;
        int[] arr = {1};
        while (sR <= eR) {
            process(result, arr, sR++, eR--, sC++, eC--);
        }
        return result;
    }

    public static void process(int[][] result, int[] startNum, int sR, int eR, int sC, int eC) {
        for (int i = sC; i <= eC; i++) {
            result[sR][i] = startNum[0]++;//横行
        }
        if (sR == eR) return;
        for (int i = sR + 1; i <= eR; i++) {
            result[i][eC] = startNum[0]++;
        }
        if (sC == eC) return;
        for (int i = eC - 1; i >= sC; i--) {
            result[eR][i] = startNum[0]++;
        }
        for (int i = eR - 1; i >= sR + 1; i--) {
            result[i][sC] = startNum[0]++;
        }
        return;

    }


}
