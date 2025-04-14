package boj.p11726_dp_타일링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P11726 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		double [] dp = new double[N+1];
		
		if(N==1) {
			System.out.println(1);
			return;
		}
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i <= N; i++) {
			
//			System.out.println(i+" " + dp[i-1]);
//			System.out.println(i+" " + dp[i-2]);
			
			
			dp[i] = dp[i-1] + dp[i-2];
//			System.out.println(i+" " + dp[i]);
//			System.out.println("");
		}
		
		
		int answer = (int) dp[N]%10007;
		System.out.println(answer);
		
	}
}
