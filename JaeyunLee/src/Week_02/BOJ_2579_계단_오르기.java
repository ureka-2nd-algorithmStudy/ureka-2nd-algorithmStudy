package Week_02;

import java.io.*;
import java.util.*;

public class BOJ_2579_계단_오르기 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] stairs, dp;
    private static int n;

    public static void main(String[] args) throws IOException {
        init();
        int result = solve();

        bw.write(result + "\n");

        bw.close();
        br.close();
    }

    private static int solve() {
        if (n == 1)
            return stairs[1];

        if (n == 2) {
            return stairs[1] + stairs[2];
        }

        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];

        for (int i = 3; i <= n; i++)
            dp[i] = Math.max(dp[i-2] + stairs[i], dp[i-3] + stairs[i-1] + stairs[i]);

        return dp[n];
    }

    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());

        stairs = new int[n+1];
        dp = new int[n+1];

        for (int i = 1; i <= n; i++)
            stairs[i] = Integer.parseInt(br.readLine());
    }
}
