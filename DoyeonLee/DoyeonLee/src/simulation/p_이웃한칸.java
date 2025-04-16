package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_이웃한칸 {
    public static void main(String[] args) {
        String[][] board = {
            {"blue", "red", "orange", "red"},
            {"red", "red", "blue", "orange"},
            {"blue", "orange", "red", "red"},
            {"orange", "orange", "red", "blue"}
        };

        int h = 1;
        int w = 1;

        int result = solution(board, h, w);
        System.out.println("결과: " + result);  
    }

	    public static int solution(String[][] board, int h, int w) {
	        
	        int n = board.length; //  행 세로
	        int m = board[0].length; // 열 가로 
	        
	        int count = 0;
	        
	        int[] dh = {0, 1, -1, 0}; // 하 상
	        int[] dw = {1, 0, 0, -1}; // 오 왼
	        
	        for ( int i = 0; i < 4; i++) {
	            int h_check = h + dh[i];
	            int w_check = w + dw[i];
	            
	            if ( h_check >= 0 && h_check < n && w_check >= 0 && w_check < m) {
	                if ( board[h][w].equals(board[h_check][w_check]) ) {
	                    count++;
	                }
	            }
	        }
	        
	        return count;
	    }
}

