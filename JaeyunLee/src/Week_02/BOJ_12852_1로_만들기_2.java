package Week_02;

import java.io.*;
import java.util.*;

public class BOJ_12852_1로_만들기_2 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] dp, path;
    private static int n;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void print() throws IOException {
        StringBuilder sb = new StringBuilder();
        int result = 0;
        int start = n;

        while (true) {
            if (start == 1) {
                sb.append(1).append(" ");
                break;
            }

            sb.append(start).append(" ");
            start = path[start];
            result++;
        }

        bw.write(result + "\n");
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void solve() {
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            path[i] = i - 1;

            if (i % 2 == 0) {
                int idx = i / 2;

                if (dp[i] > dp[idx] + 1) {
                    dp[i] = dp[idx] + 1;
                    path[i] = idx;
                }
            }

            if (i % 3 == 0) {
                int idx = i / 3;

                if (dp[i] > dp[idx] + 1) {
                    dp[i] = dp[idx] + 1;
                    path[i] = idx;
                }
            }
        }
    }

    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];
        path = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.fill(path, Integer.MAX_VALUE);

        dp[0] = 0;
    }
}
