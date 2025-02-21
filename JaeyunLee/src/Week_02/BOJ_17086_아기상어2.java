package Week_02;

import java.io.*;
import java.util.*;

public class BOJ_17086_아기상어2 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    private static final Queue<int[]> queue = new ArrayDeque<>();
    private static StringTokenizer st;
    private static int[][] maps;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        init();
        int result = solution();
        bw.write(result + "\n");

        br.close();
        bw.close();
    }

    private static int solution() {
        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] position = queue.poll();

                for (int k = 0; k < 8; k++) {
                    int nx = position[0] + dx[k];
                    int ny = position[1] + dy[k];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                        continue;

                    if (maps[nx][ny] == 0) {
                       maps[nx][ny] = 1;
                       queue.add(new int[]{nx, ny});
                    }
                }
            }

            time++;
        }

        return time - 1;
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maps = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int number = Integer.parseInt(st.nextToken());

                if (number == 1)
                    queue.offer(new int[]{i, j});

                maps[i][j] = number;
            }
        }
    }
}
