package algo.study.week7_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전1{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for(int i=0;i<n;i++) coins[i] = Integer.parseInt(br.readLine());

        int[] dp = new int[k+1];
        dp[0] = 1;
        for(int coin:coins){
            for(int j=coin;j<=k;j++){
		            // j원을 만들 수 있는 경우의 수에 (j-coin)원을 만들 수 있는 경우의 수를 더함
                // 즉, 현재 동전을 사용하여 j원을 만드는 추가적인 경우의 수를 계산
                dp[j] += dp[j-coin];
            }
        }
        System.out.println(dp[k]);
    }
}