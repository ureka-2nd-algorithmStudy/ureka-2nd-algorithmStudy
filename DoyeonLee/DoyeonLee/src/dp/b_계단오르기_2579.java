package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_계단오르기_2579 {
	 public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// 계단의 개수 N
        int N = Integer.parseInt(br.readLine());
        
        // 계단에 쓰여있는 점수 배열
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // DP 배열 초기화
        int[] dp = new int[N + 1];
        
        // 첫 번째 계단을 밟을 때는 그 점수가 최댓값
        dp[1] = arr[1];
        
        // 두 번째 계단을 밟을 때는 첫 번째와 두 번째 계단의 점수 합
        if (N > 1) {
            dp[2] = arr[1] + arr[2];
        }
        
        // 세 번째 계단부터는 점화식으로 계산
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
        }
        
        // 마지막 계단의 값이 최댓값이므로 출력
        System.out.println(dp[N]);
    }
}

/*
6
10
20
15
25
10
20
*/
