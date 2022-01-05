import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2021/12/31 11:05
 */
public class Code1105MinHeightShelves {

    public static int minHeightShelves(int[][] books, int shelfWidth) {
        int[] cache = new int[books.length + 1];
        Arrays.fill(cache, -1);
        return process(books, shelfWidth, 0, cache);
    }

    // i 本书的厚度为 books[i][0],高度为 books[i][1]
    public static int process(int[][] books, int shelfWidth, int startIndex, int[] cache) {
        if (startIndex >= books.length || shelfWidth <= 0) return 0;
        if (cache[startIndex] != -1) return cache[startIndex];
        int result = 2000 * 2000;
        int sum = 0, maxHeight = 0;
        for (int i = startIndex; i < books.length; i++) {
            sum = sum + books[i][0];
            if (sum > shelfWidth) {
                break;
            } else {
                maxHeight = Math.max(maxHeight, books[i][1]);
                int ans = process(books, shelfWidth, i + 1, cache);
                result = Math.min(result, ans + maxHeight);
            }
        }
        cache[startIndex] = result;
        return result;
    }

    public static void main(String[] args) {
        int[][] books = {{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};
        int shelf_width = 4;
        System.out.print(minHeightShelves(books, shelf_width));
    }
}
