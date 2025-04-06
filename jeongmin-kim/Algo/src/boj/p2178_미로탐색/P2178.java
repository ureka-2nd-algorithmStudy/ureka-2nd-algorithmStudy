package boj.p2178_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {
	static int[][] map;
	
	static int[] dx = { 1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][] visited; 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Node start = new Node(0,0);
		System.out.println(bfs(start,N,M));
	}
	
	static int bfs(Node start, int N, int M) {
		
		Queue<Node> queue = new ArrayDeque<Node>();
		
		queue.offer(start);
		int cnt = 0;
		while(!queue.isEmpty()) {
			int x = queue.peek().getX();
			int y = queue.peek().getY();
			for(int d = 0; d < 4; d++) {
				Node frontier = new Node(x+dx[d],y+dy[d] );
				int nX = frontier.getX();
				int nY =  frontier.getY();
				if(nX == N && nY == M) {
					return cnt;
				}
				if(!visited[nX][nY] && map[nX][nY] != 0) {
					queue.offer(frontier);
					cnt++;
				}
				
			}
		}
		
		return 0;
		
	}

	
	static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		int getX() {
			return x;
		}
		int getY() {
			return y;
		}
	}
}
