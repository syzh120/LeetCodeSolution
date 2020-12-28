import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: ybchen
 * @Date: 2020/12/25 14:39
 */
public class Code56MergeIntervals {


    /**
     * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        Interval[] datas = new Interval[intervals.length];
        List<Interval> resList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            datas[i] = new Interval(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(datas, new IntervalStartAscendingComparator());
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

    public int[][] convertList2Arr(List<Interval> resList) {
        int[][] result = new int[resList.size()][2];
        for (int i = 0; i < resList.size(); i++) {
            result[i][0] = resList.get(i).start;
            result[i][1] = resList.get(i).end;
        }
        return result;

    }


    public class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public class IntervalStartAscendingComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }


}
