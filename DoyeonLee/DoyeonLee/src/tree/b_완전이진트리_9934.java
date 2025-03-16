package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b_완전이진트리_9934 {
	
	static int[][] level;
	static int[] node;
	static int[] index;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine()); // 트리 깊이 
		int n = (1 << k ) - 1; // 노드의 개수
	
		node = new int[n]; // // 입력 노드 저장 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for ( int i = 0; i < n; i++) {
			node[i] = Integer.parseInt(st.nextToken());
		}
		
		level = new int[k][n]; // k개 레벨, 노드 최대 n개
		index = new int[k];
		
		
		tree(0, n-1, 0);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < k; i++) {
			for(int j =0; j < index[i]; j++) {
				sb.append(level[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void tree(int left, int right, int depth) {
		if (left > right ) 
			return;
		
		int mid = (left + right) / 2; // 중앙값 = 루트
		level[depth][index[depth]++] = node[mid];
		// tree(0, 6, 0)
		//	mid = 3
		// index[0] ++
		// level[0][index[0]++] = node[3]
		// level[0][0] = node[3]
		// level[0] = 3, , , , , 
		
		tree(left, mid - 1, depth + 1); // 왼쪽
		tree(mid + 1, right, depth + 1); // 오른쪽
	}
}
