package programmers.더_맵게_42626;

import java.util.PriorityQueue;

public class 더_맵게 {

    public static void main(String[] args) {
        int result1 = new 더_맵게().solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
    }

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 0;
        for (int i : scoville) {
            pq.offer(i);
        }

        while (pq.peek() < K) {
            int first = pq.poll();
            int second = 0;
            int sum = 0;

            if (!pq.isEmpty()) {
                second = pq.poll();
                sum = first + (second * 2);
                pq.offer(sum);
                cnt++;
            } else {
                return -1;
            }
        }
        return cnt;
    }
}
