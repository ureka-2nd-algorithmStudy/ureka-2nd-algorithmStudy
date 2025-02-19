package programmers.게임_맵_최단거리_1844;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {

    static int N, M;
    static int[][] map;
    static int[][] distance;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};

    public static void main(String[] args) {
        System.out.println(
                new 게임_맵_최단거리().solution(new int[][]{
                        {1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 0, 1},
                        {0, 0, 0, 0, 1}}));
        System.out.println(
                new 게임_맵_최단거리().solution(new int[][]{
                        {1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 1}}));
    }

    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        map = maps;
        distance = new int[N][M];

        bfs(0, 0);
        int answer = distance[N - 1][M - 1];
        if (answer == 0) {
            return -1;
        }
        return answer;
    }

    void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        distance[x][y] = 1;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 1 && distance[nx][ny] == 0) {
                        q.offer(new int[]{nx, ny});
                        distance[nx][ny] = distance[cx][cy] + 1;
                    }
                }
            }
        }
    }
}
