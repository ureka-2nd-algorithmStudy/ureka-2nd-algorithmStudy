package boj.p9934_이진트리_완전이진트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P9934 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		List<Integer> order = new ArrayList<Integer>();
		
		int len = 1;
		for(int i = 0; i < N-1; i ++) {
			len += len*2; 
		}
		
		for(int i = 0; i < len; i ++) {			
			order.add(Integer.parseInt(st.nextToken()));			
		}
		
		traverseDfs(order);
		
	}
	
	static void traverseDfs(List<Integer> order) {
		
		System.out.println(order.get(order.size()/2));
		if(order.size() == 1) return;
		traverseDfs(order.subList(0, order.size()/2 - 1));
		traverseDfs(order.subList(order.size()/2 + 1, order.size()-1 ));
	}
}
