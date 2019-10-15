import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ZHONGPENG769
 * @date 2019/10/15
 */
public class Logger {

    /**
     * Design a logger system that receive stream of messages along with its timestamps,
     * each message should be printed if and only if it is not printed in the last 10 seconds.
     * <p>
     * Given a message and a timestamp (in seconds granularity),
     * return true if the message should be printed in the given timestamp, otherwise returns false.
     * <p>
     * It is possible that several messages arrive roughly at the same time.
     */

    private List<String>[] buf = new List[10];
    private Set<String> set = new HashSet<>();
    private int from = 0;

    public Logger() {
        for (int i = 0; i < buf.length; i++) {
            buf[i] = new ArrayList<>();
        }
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        for (int t = from; t <= timestamp - 10; t++) {
            for (String s : buf[(t + buf.length) % buf.length]) {
                set.remove(s);
            }
            buf[(t + buf.length) % buf.length].clear();
        }
        if (!set.add(message)) {
            return false;
        }
        buf[timestamp % buf.length].add(message);
        from = timestamp - 9;
        return true;
    }
}
