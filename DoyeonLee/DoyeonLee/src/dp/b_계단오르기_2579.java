package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_계단오르기_2579 {


		static Integer dp[];
		static int arr[];
		
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int N = Integer.parseInt(br.readLine()); // 계단의 개수
			
			dp = new Integer[N + 1];
			arr = new int[N + 1];
			
			for(int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(br.readLine()); // 계단 마다의 점수 
			}
			
			dp[0] = arr[0];	// 디폴트값이 null이므로 0으로 초기화 해주어야한다. // 시작지점
			dp[1] = arr[1]; // 첫 계단부터 시작이므로 1계단에 1번째 점수 부여
			
			if(N >= 2) {
				dp[2] = arr[1] + arr[2]; // 첫 번째 계단 + 두 번째 계단 밟았을 때 점수
			}
			
			System.out.println(find(N));
			
		}
		
		static int find(int N) {
			// 아직 탐색하지 않는 N번째 계단일 경우
			if(dp[N] == null) {
				dp[N] = Math.max(find(N - 2), find(N - 3) + arr[N - 1]) + arr[N];
			}
			
			return dp[N];
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
