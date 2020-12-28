import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ybchen
 * @Date: 2020/12/28 15:31
 */
public class Code57InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{{newInterval[0], newInterval[1]}};

        }
        int[][] result = insertInArr(intervals, newInterval);
        return merge(result);

    }


    public static int getLastLessIndex(int[][] intervals, int[] target) {
        int start = 0;
        int end = intervals.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (intervals[mid][0] <= target[0]) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        if (intervals[end][0] <= target[0]) {
            return end;
        }
        return intervals[start][0] <= target[0] ? start : -1;

    }

    public static int[][] insertInArr(int[][] intervals, int[] target) {
        int index = getLastLessIndex(intervals, target) + 1;
        int[][] result = new int[intervals.length + 1][];
        for (int i = 0, j = 0; i < result.length; i++) {
            if (i == index) {
                result[i] = target;
            } else {
                result[i] = intervals[j++];
            }
        }
        return result;
    }


    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        Interval[] datas = new Interval[intervals.length];
        List<Interval> resList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            datas[i] = new Interval(intervals[i][0], intervals[i][1]);
        }

        int curStart = datas[0].start;
        int curEnd = datas[0].end;
        for (int i = 1; i < datas.length; i++) {
            if (datas[i].start <= curEnd) {
                //can continue merge
                curEnd = Math.max(curEnd, datas[i].end);
            } else {
                resList.add(new Interval(curStart, curEnd));
                curStart = datas[i].start;
                curEnd = datas[i].end;
            }
            if (i == datas.length - 1) {
                resList.add(new Interval(curStart, curEnd));
            }
        }
        return convertList2Arr(resList);

    }

    public static int[][] convertList2Arr(List<Interval> resList) {
        int[][] result = new int[resList.size()][2];
        for (int i = 0; i < resList.size(); i++) {
            result[i][0] = resList.get(i).start;
            result[i][1] = resList.get(i).end;
        }
        return result;

    }


    public static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {

        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        System.out.println(insert(intervals, newInterval).toString());
        //
    }
}
