package bj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BOJ_계단오르기_2579 {
	
	static int N;
	static int[] stairs;
	static int[][] dp; // 인덱스 -> 현재 밟은 계단의 위치와 현재까지 밟은 계단 수, 값 -> 저장된 점수의 최댓값
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	stairs = new int[N + 1];
    	dp = new int[N + 1][4];
    	
    	for(int i = 1; i <= N; i++) {
    		stairs[i] = Integer.parseInt(br.readLine());
    	}
    	
    	dp[1][1] = stairs[1]; // 기저 조건
    	
    	for(int i = 2; i <= N; i++) {
			dp[i][1] = Math.max(dp[i - 2][1], dp[i - 2][2]) + stairs[i];
    		dp[i][2] = dp[i - 1][1] + stairs[i];
    			
    	}
    	
    	System.out.println(Math.max(dp[N][1], dp[N][2]));
	}	

	
}

