package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p_피보나치수 {

    // 전역 dp 배열 선언
    static long[] dp = new long[100001];

    public static void main(String[] args) throws Exception {
        // BufferedReader로 표준 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // 입력 받은 문자열을 정수로 변환

        // dp 배열의 값 계산 및 출력
        System.out.println(fibo_dp(n));
    }

    // 피보나치 수를 구하는 함수
    static long fibo_dp(int n) {
        dp[0] = 0;
        dp[1] = 1;

        // 2번째 부터 n 까지 피보나치 계산
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;  // 1234567로 나누어 나머지를 구함
        }

        return dp[n];  // n번째 피보나치 수 반환
    }
}
