package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b_쇠막대기_10799 {

	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        // 입력을 받음
	        String par = br.readLine();
	        
	        int pieceCount = 0;  // 잘린 쇠막대기의 총 조각 수
	        Stack<Character> stack = new Stack<>();  // 괄호를 추적하기 위한 스택
	        
	        for (int i = 0; i < par.length(); i++) {
	            char current = par.charAt(i);
	            
	            if (current == '(') {
	                // 쇠막대기의 시작
	                stack.push(current);
	            } else if (current == ')') {
	                stack.pop();  // 쇠막대기의 끝
	                
	                // 레이저인지 확인
	                if (par.charAt(i - 1) == '(') {
	                    // 레이저라면, 현재까지 열린 쇠막대기 개수만큼 조각 추가
	                    pieceCount += stack.size();
	                } else {
	                    // 레이저가 아니면 쇠막대기가 끝나면서 조각이 하나 늘어남
	                    pieceCount += 1;
	                }
	            }
	        }
	        
	        // 결과 출력
	        System.out.println(pieceCount);
	    }
	}

