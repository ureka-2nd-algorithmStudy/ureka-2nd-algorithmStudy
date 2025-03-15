package boj.p1931_greedy_회의실배정;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1931 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Node> list = new ArrayList<Node>();
		for(long i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long start = Integer.parseInt(st.nextToken());
			long end = Integer.parseInt(st.nextToken());
			Node node = new Node(i, start,end);
			list.add(node);			
		}
		list.sort((o1,o2) -> Long.compare(o1.getEnd(),o2.getEnd()));
//        list.sort((o1, o2) -> o1.getEnd() == o2.getEnd() ? Long.compare(o1.getStart(), o2.getStart()) : Long.compare(o1.getEnd(), o2.getEnd()));
		
		System.out.println(list);
		long cnt = 0; 		
		long curEnd = 0;
		long curStart = 0;
		if(list.get(0).getStart() <= list.get(0).getEnd()) {
			cnt = 1; 		
			curEnd = list.get(0).getEnd();
			curStart = list.get(0).getStart();	
		}
		
		
		for(int i = 1; i < list.size();i ++){
			if(list.get(i).getStart() > list.get(i).getEnd()) {
				continue;
			}
			if(list.get(i).getStart() < curEnd) {
				continue;
			}
			
//			if(list.get(i).getStart() == list.get(i).getEnd() && list.get(i).getEnd() == curEnd && list.get(i).getStart() == curStart) {
//				continue;
//			}
//			System.out.println(list.get(i).getI());
			cnt++;
			curEnd = list.get(i).getEnd();
			curStart = list.get(i).getStart();
		}
		System.out.println(cnt);
	}
	
	static class Node{
		@Override
		public String toString() {
			return "Node [i=" + i + ", start=" + start + ", end=" + end + "]";
		}
		long i;
		long start;
		long end;
		public Node(long i, long start, long end) {
			this.i = i;
			this.start =start;
			this.end = end;
		}
		long getI() {
			return this.i;
		}
		long getStart() {
			return this.start;
		}
		long getEnd() {
			return this.end;
		}
		
		
		
	}
//4
//3 3
//1 3
//2 3
//3 4

//4
//1 4
//2 4
//3 4
//4 4

//13
//0 6
//1 4
//3 5
//5 7
//3 8
//5 9
//6 10
//8 11
//8 12
//2 13
//12 14
//14 14
//14 15
//13
//1 4
//3 5
//0 6
//5 7
//3 8
//5 9
//6 10
//8 11
//8 12
//2 13
//12 14
//14 14
//14 14
	
//11
//1 4
//1 4
//0 6
//5 7
//3 8
//5 9
//6 10
//8 11
//8 12
//2 13
//12 14   
	
}
