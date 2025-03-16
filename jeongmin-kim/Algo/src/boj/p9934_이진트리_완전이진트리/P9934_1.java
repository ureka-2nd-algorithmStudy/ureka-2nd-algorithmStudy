package boj.p9934_이진트리_완전이진트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P9934_1 {
	static int depthEle;
	static int[] depth;
//	static int level;
	static ArrayList<ArrayList<Integer>> levelInfo;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		List<Integer> order = new ArrayList<Integer>();
		
		int len = 0;
		for(int i = 0; i < N; i ++) {			
			len += Math.pow(2,i); 
		}
		
		for(int i = 0; i < len; i ++) {			
			order.add(Integer.parseInt(st.nextToken()));			
		}
		depth = new int[len];
				
		levelInfo = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i <= N; i++ ) {
			ArrayList<Integer> nodes = new ArrayList<>();
			levelInfo.add(nodes);
		}
		
//		level = 0;
		
		traverseDfs(order, 0);			
		
		for(int i = 0; i <= levelInfo.size()-1; i ++) {
			for( int j = 0; j < levelInfo.get(i).size(); j ++ ) {
				System.out.print(levelInfo.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	static void traverseDfs(List<Integer> order, int level) {
		if(order.size() == 1) {		
//			System.out.println(level);
			levelInfo.get(level).add(order.get(0));
			return;
		}
		int root = order.get(order.size()/2);
		levelInfo.get(level).add(root);		
		
		level++;
		
		traverseDfs(order.subList(0, order.size()/2), level);
		traverseDfs(order.subList(order.size()/2 + 1, order.size()),level);
		
	}
}
/*
3
6
1
4
2
5
7
*/