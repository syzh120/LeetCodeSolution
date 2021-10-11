import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: ybchen
 * @Date: 2021/10/8 10:42
 */
public class Code354MaxEnvelopes {
    /**
     * 俄罗斯信封问题
     *
     * @param envelopes
     * @return
     */
    public static int maxEnvelopes(int[][] envelopes) {
        Envelope[] Envelopes = new Envelope[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            Envelopes[i] = new Envelope(envelopes[i][0], envelopes[i][1]);
        }
        int res = 1;
        Arrays.sort(Envelopes, new EnvelopeComp());
        int[] dp = new int[envelopes.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (Envelopes[i].hi > Envelopes[j].hi) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;

    }

    public static class Envelope {
        int wi;
        int hi;

        public Envelope(int wi, int hi) {
            this.wi = wi;
            this.hi = hi;
        }
    }

    public static class EnvelopeComp implements Comparator<Envelope> {
        @Override
        public int compare(Envelope o1, Envelope o2) {
            return o1.wi - o2.wi == 0 ? o2.hi - o1.hi : o1.wi - o2.wi;
        }
    }

    public static void main(String[] args) {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.print(maxEnvelopes(envelopes));
    }
}
