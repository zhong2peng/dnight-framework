import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ZHONGPENG769
 * @date 2019/10/12
 */
public class MedianFinder {

    PriorityQueue<Integer> minHeap = null;
    PriorityQueue<Integer> maxHeap = null;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        if (minHeap.size() < maxHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }
}
