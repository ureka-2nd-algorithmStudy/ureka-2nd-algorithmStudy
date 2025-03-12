package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p_단어변환 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String begin = br.readLine();
		String target = br.readLine();
		
		String[] words = br.readLine().split(" ");
		
        p_단어변환 solution = new p_단어변환();
        int answer = solution.solution(begin, target, words);
        System.out.println(answer);  // 결과 출력
    }
		
	
    
	
	public int solution(String begin, String target, String[] words) {
		int answer = bfs(begin, target, words);
		
		return answer; // 결과
	}
	
	// *****
	public static boolean OneChar(String word1, String word2) { // word1, word2 1글자만 다른지 확인
		int diffcnt = 0; // 몇 글자가 다른지 세기 
		for ( int i = 0 ; i < word1.length(); i++ ) {
			if ( word1.charAt(i) != word2.charAt(i)) {
				diffcnt++; // 단어가 1글자만 다르면 true -> 한 글자만 변경 가능하므로
			}
		}
		
		return diffcnt == 1; // 단어가 1글자만 다르면 true
	}
	
	
	public static int bfs(String begin, String target, String[] words) {
		int a = words.length; 
		
		// ******* target 이 words 에 없으면 안 됨 
		// word 에 있는 단어들과 target 단어 동일한지 비교 
		boolean targetWords = false;
		for ( String word : words) {
			if ( word.equals(target)) {
				targetWords = true; // 동일하면 종료
				break;
			}
		}
		
		// target 이 words 에 없으면 0 반환 
		// 동일하지 않음(false) 이면 0 을 반환 
		if ( !targetWords) {
			return 0;
		}
		
		
		// 방문 여부 
		boolean[] visited = new boolean[a];
		
		
		Queue<int[]> queue = new LinkedList<>();
		
        for (int i = 0; i < a; i++) {
            if (OneChar(begin, words[i])) { // 한 글자만 다른 경우 true 반환 
                queue.offer(new int[] {i, 1});  // words[i] 와 변환 횟수 1번을 추가 
                visited[i] = true; // 방문했으므로 true 로 
                // hit -> hot  과 한 글자만 다름 (0,1) queue = (0,1) 
            }
        }

		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int move = current[0]; // hot
			int dis = current[1]; // 1
			
			if (words[move].equals(target)) { // 현재 단어가 target 과 같은 단어이면 변환 완료
				return dis; // 횟수 반환 
			}
			
			for ( int i = 0; i < a; i++) {
				if ( !visited[i] && OneChar(words[move], words[i])) { // 방문하지 않았으며, 1글자만 다른 단어들인 경우 반복 
					visited[i] = true;
					
					queue.offer(new int[] { i, dis + 1});
					
					// 1반 변환 / hot(0,1) 꺼내고 -> dot, lot 한 글자만 다름 queue = (1,2) (3,2)
					// 2번 변환 / dot(1,2) 꺼내고 -> dog 한 글자만 다름/ hot, lot 이미 방문 / queue = (3,2) (2,3)
					// 3번 변환 / lot(3,2) 꺼내고 -> log 한 글자만 다른 / hot, dot 이미 방문 / queue = (2,3) (4,3)
					// 4번 변환 / dog(2,3) 꺼내고 -> cog 한 글자만 다름 / dot, log 이미 방문 / queue = (4,3) (5,4)
				}
			
			}
			
		}
		
		return 0; // queue 비어있는 경우 반환 불가능
	}
		
		
	
}
	
