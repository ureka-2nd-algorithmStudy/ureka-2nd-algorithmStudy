package programmers.네트워크_43162;

import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {

    static boolean[] visited;
    static int netCnt;

    public static void main(String[] args) {
        System.out.println(new 네트워크().solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(new 네트워크().solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, computers);
                netCnt++;
            }
        }
        return netCnt;
    }

    void bfs(int start, int[][] coms) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int v = q.poll();
            for (int i = 0; i < coms.length; i++) {
                if (!visited[i] && coms[v][i] == 1) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
