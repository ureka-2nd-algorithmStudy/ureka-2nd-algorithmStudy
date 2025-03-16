package boj.p9934_이진트리_완전이진트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P9934 {
	
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		List<Integer> order = new ArrayList<Integer>();
		
		int len = 0;
		for(int i = 0; i < N; i ++) {			
			len += Math.pow(2,i); 
		}
		
		visit = new boolean[len];
		
		for(int i = 0; i < len; i ++) {			
			order.add(Integer.parseInt(st.nextToken()));			
		}
		
		traverseBfs(order);			

	}
	
	static void traverseBfs(List<Integer> order) {
		 Queue<Integer> queue = new ArrayDeque<>();
		 System.out.println(order.get(order.size()/2));
		 queue.offer(order.size()/2);
		 
		 //왼쪽의 절반 idx 노드, 오른쪽의 절반 idx 노드
		 
		 boolean notYet = true;	 
		 while(!queue.isEmpty()) {
			 
			 int curNodeIdx = queue.poll();
			 
			 int left = (curNodeIdx-1)/2;
			 int right = (curNodeIdx-1)/2 + curNodeIdx + 1;
			 			 
			 visit[left] = true;
			 System.out.println(left);			 
			 queue.offer(left);
//			 System.out.println(order.get(left));
			 
			 visit[right] = true;
			 System.out.println(right);
			 queue.offer(right);
//			 System.out.println(order.get(right));
		 }
		
	}

}
//2
//2 1 3


//3
//1 6 4 3 5 2 7