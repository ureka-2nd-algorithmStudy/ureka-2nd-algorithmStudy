package Week_01;

import java.io.*;
import java.util.*;

public class BOJ_9663_NQueen {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] maps;
    private static int n, count = 0;

    public static void main(String[] args) throws IOException {
        init();
        dfs(0);
        bw.write(count + "\n");
        close();
    }

    private static void dfs(int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (validation(depth, i)) {
                maps[depth][i] = 1;
                dfs(depth + 1);
                maps[depth][i] = 0;
            }
        }
    }

    private static boolean validation(int x, int y) {
        for (int i = x - 1; i >= 0; i--)
            if (maps[i][y] == 1)
                return false;

        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--)
            if (maps[i][j] == 1)
                return false;

        for (int i = x - 1, j = y + 1; i >= 0 && j < n; i--, j++)
            if (maps[i][j] == 1)
                return false;

        return true;
    }

    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        maps = new int[n][n];
    }

    private static void close() throws IOException {
        br.close();

        bw.flush();
        bw.close();
    }
}


