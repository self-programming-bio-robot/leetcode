import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue(Comparator.reverseOrder());
        for (int x: stones) q.add(x);    
    
        while (q.size() > 1) {
            int a = q.poll();
            int b = q.poll();
            q.add(a - b);
        }
        
        return q.isEmpty() ? 0 : q.poll();
    }
}
