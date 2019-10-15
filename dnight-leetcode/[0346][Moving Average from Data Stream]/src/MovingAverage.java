import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ZHONGPENG769
 * @date 2019/10/15
 */
public class MovingAverage {

    /**
     * Given a stream of integers and a window size,
     * calculate the moving average of all integers in the sliding window.
     */

    private double previousSum = 0.0;
    private int maxSize;
    private Queue<Integer> currentWindow;

    public MovingAverage(int size) {
        currentWindow = new LinkedList<>();
        maxSize = size;
    }

    public double next(int val) {
        if (currentWindow.size() == maxSize) {
            previousSum -= currentWindow.remove();
        }
        currentWindow.add(val);
        previousSum += val;
        return previousSum / currentWindow.size();
    }
}
