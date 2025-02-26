package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class b_단어순서뒤집기_12605 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			
			String[] words = line.split(" ");
			
			Stack<String> stack = new Stack<>();
			
			for(String word : words) {
				stack.push(word);
			}
			
			StringBuilder sb = new StringBuilder();
			while( !stack.isEmpty()) {
				sb.append(stack.pop());
				if (!stack.isEmpty()) {
					sb.append(" "); // 공백을 추가해주기
				}
				
				}
			
			System.out.println("Case #" + (i+1) + ": " + sb.toString());
		}
		
			
		}

	}