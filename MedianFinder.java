import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: ybchen
 * @Date: 2021/3/24 14:53
 */
public class MedianFinder {
    public class AscendingComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.intValue() - o1.intValue();
        }
    }


    private PriorityQueue<Integer> minPQ;
    private PriorityQueue<Integer> maxPQ;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>(new AscendingComparator());
    }

    public void addNum(int num) {
        //小顶堆存放大的数
        if (minPQ.isEmpty() || num > minPQ.peek()) {
            minPQ.add(num);
        } else {
            //大顶堆存放小的数
            maxPQ.add(num);
        }
        modify2Heaps();
    }

    public double findMedian() {
        if ((maxPQ.size() + minPQ.size()) % 2 == 0) {
            return (minPQ.peek() + maxPQ.peek()) / 2.0;
        } else {
            return minPQ.size() > maxPQ.size() ? minPQ.peek() : maxPQ.peek();
        }
    }

    public void modify2Heaps() {
        if (maxPQ.size() - minPQ.size() >= 2) {
            minPQ.add(maxPQ.poll());
        } else if (minPQ.size() - maxPQ.size() >= 2) {
            maxPQ.add(minPQ.poll());
        }
    }
}
