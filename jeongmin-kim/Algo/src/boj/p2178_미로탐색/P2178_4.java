package boj.p2178_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178_4 {
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
			char[] arr = br.readLine().toCharArray();
			
			for(int j = 0; j < M; j ++) {
				map[i][j] = Integer.valueOf(arr[j]);
			}
		}
		Node start = new Node(0,0,1);
		System.out.println(bfs(start,N,M));
	}
	static int bfs(Node start, int N, int M) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(start);
		visited[start.getX()][start.getY()] = true;

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int x = node.getX();
			int y = node.getY();
			int dist = node.getDist();

			if (x == N - 1 && y == M - 1) {
				return dist;
			}

			for (int d = 0; d < 4; d++) {
				int nX = x + dx[d];
				int nY = y + dy[d];

				if (nX >= 0 && nY >= 0 && nX < N && nY < M) {
					if (!visited[nX][nY] && map[nX][nY] == 1) {
						visited[nX][nY] = true;
						queue.offer(new Node(nX, nY, dist + 1)); // ← 여기!
					}
				}
			}
		}

		return -1;
	}


	
	static class Node {
		int x;
		int y;
		int dist;
		public Node(int x, int y,int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		
		int getX() {
			return x;
		}
		int getY() {
			return y;
		}
		int getDist() {
			return dist;
		}
	}
}