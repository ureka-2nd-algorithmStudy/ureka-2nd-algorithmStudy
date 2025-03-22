import java.util.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    public String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length];
        
        // 도착지를 기준으로 사전순 정렬
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        sb.append("ICN ");
        // 마지막 cnt는 티켓을 몇개 썼는지 누적
        // 이를 tickets.length와 비교하여 DFS종료조건 설정
        DFS("ICN", visited, tickets, 0);
        
        String[] answer = sb.toString().trim().split(" ");
        return answer;
    }
    
    private boolean DFS(String start, boolean[] visited, String[][] tickets, int cnt) {
        // 모든 티켓을 사용했다면 경로 완성
        if (cnt == tickets.length) {
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                sb.append(tickets[i][1]).append(" ");
                
                // 다음 경로 탐색
                if (DFS(tickets[i][1], visited, tickets, cnt + 1)) return true;
								
								// StringBuilder.delete(int startIdx, int endIdx)
                sb.delete(sb.length() - (tickets[i][1].length() + 1), sb.length());
                visited[i] = false;
            }
        }

        // 가능한 경로가 없을 경우
        return false;
    }
}