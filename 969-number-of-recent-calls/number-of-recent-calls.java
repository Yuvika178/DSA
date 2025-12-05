import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    private Queue<Integer> q;

    public RecentCounter() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        q.offer(t);
        int lower = t - 3000;
        // Window me sirf woh timestamps rakhe jo >= t-3000 hain
        while (q.peek() != null && q.peek() < lower) {
            q.poll();
        }
        return q.size();
    }
}
