/**
 * @Author: ybchen
 * @Date: 2021/8/12 17:15
 */
public class CodeChooseArea {

    public static class Area {
        int x;
        int y;

        public Area(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * dp[i][j]:血量为A B
     *
     * @param A
     * @param B
     * @param X
     * @param Y
     * @param Z
     * @return
     */
    public static int chooseArea(int A, int B, Area X, Area Y, Area Z) {
        int[][] dp = new int[A + 1][B + 1];
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                dp[i][j] = dp[X][]
//            }
//        }


        return dp[A][B];
    }

    public static void main(String[] args) {

        int A = 20;
        int B = 8;
        Area X = new Area(3, 2);
        Area Y = new Area(-5, -10);
        Area Z = new Area(-20, 5);
        System.out.println(chooseArea(A, B, X, Y, Z));
    }
}
