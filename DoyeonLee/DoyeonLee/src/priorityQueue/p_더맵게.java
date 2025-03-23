package priorityQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p_더맵게 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] scoville = new int[n];
		st = new StringTokenizer(br.readLine());
		for ( int i = 0; i < n; i ++) {
			scoville[i] = Integer.parseInt(st.nextToken());
		}
		
		p_더맵게 sol = new p_더맵게();
		System.out.println(sol.solution(scoville, K));
	}

	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for ( int sco : scoville) {
			pq.offer(sco);
		}
		
		int count = 0;
		
		while ( pq.size() >= 2 ) { // *****pq 에 적어도 요소가 2개 이상일때
			if ( pq.peek() >= K) { // 스코빌이 K 이상인 경우
				return count;
			}
			
			int a = pq.poll(); // 스코빌 제일 낮은 지수
			int b = pq.poll(); // 스코빌 그 다음으로 낮은 지수
			int mix = a + (b * 2); // 낮은 지수들 끼리 mix 
			
			pq.offer(mix); 
			count++; // 낮은 지수끼리 섞었으므로 섞은 횟수 추가
		}
		
		return pq.peek() >= K ? count : -1; // K이상인 경우 count / 아닌 경우 -1 출력
	}

}