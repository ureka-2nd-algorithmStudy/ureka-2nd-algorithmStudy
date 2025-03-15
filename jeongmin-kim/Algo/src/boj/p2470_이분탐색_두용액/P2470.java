package boj.p2470_이분탐색_두용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P2470 {
	static List<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i ++) {			
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		list.sort((o1,o2) -> Integer.compare(o1 , o2));
//		list.sort((o1, o2) -> (o1 < o2) ? -1 : (o1 > o2) ? 1 : 0);

		int s = 0;
		int e = list.size() - 1;
		
		while(list.get(s) + list.get(e) == 0) {			
			if(list.get(s)+list.get(e) > 0) {
				if(e - 1 <= s) {
					break;
				}
				e = e - 1;
			}
			
			if(list.get(s) + list.get(s) < 0){
				if(s + 1 >= e) {
					break;
				}
				s = s + 1;
			}
		}
		
		System.out.println(list.get(s) + " " + list.get(e));
	}
	
	
}
