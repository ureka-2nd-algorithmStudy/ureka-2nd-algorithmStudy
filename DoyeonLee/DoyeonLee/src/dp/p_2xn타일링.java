package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p_2xn타일링 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(solution(n));

	}
	
    static int[] dp = new int[60001]; // 범위 지정
    
    public static int solution(int n) {
        dp[1] = 1;
        dp[2] = 2;
        
        for ( int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007; // 경우의 수를 1000000007로 나눈 나머지
        }
        
        return dp[n];
    }
}


