import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int cnt = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int s : scoville) {
            pQ.offer(s);
        }

        while (pQ.size() > 1 && pQ.peek() < K) {
            int s1 = pQ.poll();
            int s2 = pQ.poll();
            int newScoville = s1 + (s2 * 2);
            pQ.offer(newScoville);
            cnt++;
        }

        if (pQ.peek() >= K) {
            return cnt;
        } else {
            return -1;
        }
    }
}