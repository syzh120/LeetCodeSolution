/**
 * @Author: ybchen
 * @Date: 2021/8/16 18:52
 */
public class Code374GuessGameI {
    /**
     * Forward declaration of guess API.
     *
     * @param num your guess
     * @return -1 if num is lower than the guess number
     * 1 if num is higher than the guess number
     * otherwise return 0
     * int guess(int num);
     */
    int guess(int num) {
        return 0;
    }

    private final int GuessLower = -1;
    private final int GuessUpper = -1;
    private final int Hint = 0;


    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = end + (end - start) / 2;
            if (guess(mid) == 1) {
                start = mid + 1;
            } else if (guess(mid) == -1) {
                end = mid - 1;
            } else {
                return mid;
            }

        }

        return guess(start) == 0 ? start : end;
    }
}
