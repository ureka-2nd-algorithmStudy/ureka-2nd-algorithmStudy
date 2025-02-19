package Week_02;

import java.util.*;

public class Solution_게임_맵_최단거리 {
    public int solution(int[][] maps) {
        return simulation(maps);
    }

    private int simulation(int[][] maps) {
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, -1, 0, 1 };

        int n = maps.length;
        int m = maps[0].length;
        int count = 1;
        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{0, 0});
        maps[0][0] = 2;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                int[] position = queue.poll();

                if (position[0] == n - 1 && position[1] == m - 1) {
                    return count;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = position[0] + dx[i];
                    int ny = position[1] + dy[i];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                        continue;

                    if (maps[nx][ny] == 0)
                        continue;

                    if (maps[nx][ny] == 1) {
                        queue.add(new int[]{nx, ny});
                        maps[nx][ny] = 2;
                    }
                }
            }
            count++;

        }

        return -1;
    }
}
