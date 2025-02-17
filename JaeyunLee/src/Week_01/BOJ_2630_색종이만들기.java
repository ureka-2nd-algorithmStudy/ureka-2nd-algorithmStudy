package Week_01;

import java.io.*;
import java.util.*;

public class BOJ_2630_색종이만들기 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] maps;
    private static int n, white = 0, blue = 0;

    public static void main(String[] args) throws IOException {
        init();
        solution(0, 0, n);
        bw.write(white + "\n");
        bw.write(blue + "\n");
        close();
    }

    private static void solution(int r, int c, int size) {
        if (size == 1) {
            if (maps[r][c] == 0)
                white++;
            else
                blue++;
            return;
        }

        boolean isBlue = true;
        boolean isWhite = true;

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (maps[i][j] != 1) {
                    isBlue = false;
                    break;
                }
            }
            if (!isBlue) break;
        }

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (maps[i][j] != 0) {
                    isWhite = false;
                    break;
                }
            }
            if (!isWhite) break;
        }

        if (isBlue) {
            blue++;
            return;
        }

        if (isWhite) {
            white++;
            return;
        }

        int newSize = size / 2;
        solution(r, c, newSize);
        solution(r, c + newSize, newSize);
        solution(r + newSize, c, newSize);
        solution(r + newSize, c + newSize, newSize);
    }

    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());

        maps = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                maps[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    private static void close() throws IOException {
        br.close();

        bw.flush();
        bw.close();
    }
}
