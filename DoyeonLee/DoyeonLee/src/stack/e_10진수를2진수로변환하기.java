package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class e_10진수를2진수로변환하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ten = Integer.parseInt(br.readLine());
		
		System.out.println(change(ten));
	}
	
	// 10진수를 2진수로
	public static String change(int ten) {
		Stack<Integer> stack = new Stack<>();
		
		while ( ten != 0 ) { // 10진수 가 0이 아니라면
			int remainder = ten % 2; // 10진수를 나눈 나머지 구한다.
			stack.push(remainder); // 나머지를 remainder 에 저장
			ten /= 2; // 10진수를 2로 나눈다.
		}
		
		StringBuilder sb = new StringBuilder();
		while ( !stack.isEmpty()) { // 스택이(remainder) 비어있지 않으면
			sb.append(stack.pop()); // 스택에서 저장해 둔 나머지를 하나씩 꺼낸다.
									// 10진수 10 일 경우 0101 저장된 것을 꺼낸 순서대로 추가하여 1010
		}
		
		return sb.toString(); // 꺼낸 나머지를 문자열로
	}

}
