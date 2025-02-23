import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단_오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // 계단의 수
        int[] stairs = new int[n + 1];  // 계단의 점수
        int[] dp = new int[n + 1];  // 각 계단까지의 최대 점수

        // 계단 점수 입력
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());;
        }

        // 기본 케이스
        dp[1] = stairs[1];  // 첫 번째 계단은 그 자체의 점수
        if (n > 1) {
            dp[2] = stairs[1] + stairs[2];  // 두 번째 계단은 첫 번째 계단 + 두 번째 계단
        }

        // DP 배열 채우기
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
        }

        // 마지막 계단까지의 최대 점수 출력
        System.out.println(dp[n]);
    }
}
