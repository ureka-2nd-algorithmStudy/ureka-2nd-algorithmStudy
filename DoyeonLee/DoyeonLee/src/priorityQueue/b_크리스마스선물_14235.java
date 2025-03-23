package priorityQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b_크리스마스선물_14235 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder(); //출력 결과
		int n = Integer.parseInt(st.nextToken()); // 거점지 방문 또는 아이들을 만나는 횟수
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x); // 내림차순
		for ( int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			for ( int j = 0; j < a; j++) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
			
			if ( a != 0 ) { // 거점지
				continue;
			}
			
			if ( !pq.isEmpty()) {
				sb.append(pq.poll()).append("\n"); // pq 에 선물이 있는 경우 꺼내서 sb에 저장
			} else {
				sb.append(-1).append("\n"); // pq 가 비어 있는 경우 줄 선물이 없는 경우 이므로 -1을 sb에 저장
			}
		}
		
		System.out.println(sb.toString()); // 결과가 저장된 sb 출력

	}

}


/*
5
0
2 3 2
0
0
0
 */ 
