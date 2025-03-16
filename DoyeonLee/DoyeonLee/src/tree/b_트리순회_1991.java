package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b_트리순회_1991 {
	
	static char[] leftChild = new char[26];
	static char[] rightChild = new char[26];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for ( int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			char root = input[0].charAt(0);
			char left = input[1].charAt(0);
			char right = input[2].charAt(0);
			
			leftChild[root - 'A'] = left == '.' ? '.' : left;
			rightChild[root - 'A'] = right == '.' ? '.' : right; 
		}
		
		StringBuilder sb = new StringBuilder();
		
		// 전우ㅏ
		preorder('A', sb);
		sb.append("\n");
		
		// 중위
		inorder('A', sb);
		sb.append("\n");
		
		// 후위
		postorder('A', sb);

		System.out.println(sb.toString());
	}
	
	// 전위 루트- 왼 - 노
	static void preorder(char node, StringBuilder sb) {
		if ( node == '.') return;
		sb.append(node);
		preorder(leftChild[node - 'A'], sb); // 왼쪽
		preorder(rightChild[node - 'A'], sb); // 오른쪽
		
	}
	
	// 중위 뇜 - 류투 - 오
	static void inorder(char node, StringBuilder sb) {
		if ( node == '.') return;
		sb.append(node);
		inorder(leftChild[node - 'A'], sb); // 왼쪽
		inorder(rightChild[node - 'A'], sb); // 오른쪽
	}
	
	// 후위 : 왼 오 루트
	static void postorder(char node, StringBuilder sb) {
		if ( node == '.') return;
		sb.append(node);
		postorder(leftChild[node - 'A'], sb); // 왼쪽
		postorder(rightChild[node - 'A'], sb); // 오른쪽
	}

}
