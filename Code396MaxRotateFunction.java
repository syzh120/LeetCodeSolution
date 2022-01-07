import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author: ybchen
 * @Date: 2022/1/6 10:12
 */
public class Code396MaxRotateFunction {

    public static int maxRotateFunction(int[] nums) {
        LinkedList<Integer> numList = new LinkedList<Integer>();
        for (int num : nums) {
            numList.add(num);
        }

        return maxRotateFunction(numList);
    }


    public static int calculRotSum(LinkedList<Integer> numList) {
        int sum = 0;
        for (int i = 0; i < numList.size(); i++) {
            sum = sum + numList.get(i) * i;
        }
        return sum;
    }


    public static int maxRotateFunction(LinkedList<Integer> numList) {
        int max = 0;
        int size = numList.size();
        for (int i = 0; i < size; i++) {
            int number = numList.removeLast();
            numList.addFirst(number);
            max = Math.max(calculRotSum(numList), max);

        }
        return max;

    }


    public static boolean isBipartite(int[][] graph) {
        int nodes = graph.length;
        boolean[] visited = new boolean[nodes];
        int[] colors = new int[nodes];
        Arrays.fill(colors, -1);


        if (!dfs(graph, visited, colors, 0, 0)) {

            return false;
        }


        return true;
    }

    public static boolean dfs(int[][] graph, boolean[] visited, int[] colors, int curColor, int curNode) {
        visited[curNode] = true;
        colors[curNode] = curColor;
        for (int nextNode : graph[curNode]) {
            if (visited[nextNode] == false) {
                colors[nextNode] = 1 - curColor;
                visited[nextNode] = true;
                if (!dfs(graph, visited, colors, 1 - curColor, nextNode)) {
                    return false;
                }
            } else {
                if (colors[nextNode] == colors[curNode]) {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 6};
        System.out.print(maxRotateFunction(nums));
    }
}
