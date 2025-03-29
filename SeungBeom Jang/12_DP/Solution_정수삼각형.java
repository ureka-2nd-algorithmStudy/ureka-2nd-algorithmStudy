package pr;

public class Solution_정수삼각형 {
	class Solution {
	    static int[][] dp; // dp[i][j] : i행 j열까지 거쳐온 최댓값
	    
	    public int solution(int[][] triangle) {
	        int answer = 0;
	        
	        int N = triangle.length;
	        
	        dp = new int[N][N];
	        dp[0][0] = triangle[0][0]; // base condition
	        
	        for(int i = 1; i < N; i++){
	            int M = triangle[i].length;
	            
	            // dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j]
	            for(int j = 0; j < M; j++){
	                if(j - 1 >= 0) dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
	                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + triangle[i][j]);
	            }
	        }
	        
	        // 최댓값 : dp[N - 1][0], dp[N - 1][1], ... dp[N - 1][N - 1] 중 최댓값
	        for(int i = 0; i < N; i++) {
	            answer = Math.max(answer, dp[N - 1][i]);
	        }
	        
	        return answer;
	    }
	}
}
