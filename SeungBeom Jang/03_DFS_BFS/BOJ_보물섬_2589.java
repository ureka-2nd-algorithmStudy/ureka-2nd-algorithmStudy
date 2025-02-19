package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
public class BOJ_보물섬_2589 {

	static int N, M;
	static int[][] dist;
	static char[][] board;
	static Queue<int[]> q = new ArrayDeque<>();
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int MX;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());	
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	dist = new int[N][M];
    	board = new char[N][M];
    	
    	for(int i = 0; i < N; i++) {
    		char[] c = br.readLine().toCharArray();
    		
    		for(int j = 0; j < M; j++) {
    			board[i][j] = c[j];
    		}
    	}
    	
    	// 최단거리 중 가장 긴 시간이 걸리는 곳 구하기
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < M; j++) {
    			if(board[i][j] == 'W') continue;			
     
    			for(int k = 0; k < N; k++)
    				Arrays.fill(dist[k], -1);
    			
    			q.offer(new int[] {i, j});
    			dist[i][j] = 0;
    			
    			
    			while(!q.isEmpty()) {
    				int[] cur = q.poll();
    				
    				int x = cur[0];
    				int y = cur[1];
    				
    				
    				if(dist[x][y] > MX) {
    					MX = dist[x][y];
    				}
    				
    				for(int dir = 0; dir < 4; dir++) {
    					int nx = x + dx[dir];
    					int ny = y + dy[dir];
    					
    					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
    					if(board[nx][ny] == 'W' || dist[nx][ny] >= 0) continue;
    					
    					dist[nx][ny] = dist[x][y] + 1;
    					q.offer(new int[] {nx, ny});
    				}
    			}
    			
    		}
    	}		 

    	
    	System.out.println(MX);
    }
}
