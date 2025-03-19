package backtraking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class p_여행경로 {

	public static void main(String[] args) {
		p_여행경로 solution = new p_여행경로();
        
        String[][] tickets = {
            {"ICN", "SFO"},
            {"ICN", "ATL"},
            {"SFO", "ATL"},
            {"ATL", "ICN"},
            {"ATL", "SFO"}
        };

        System.out.println(Arrays.toString(solution.solution(tickets)));
        // 출력: [ICN, ATL, ICN, SFO, ATL, SFO]
    }
	

	    int length = 0;
	    boolean[] visited;
	    ArrayList<String> list;
	    
	    public String[] solution(String[][] tickets) { // tickets : 출발지와 도착지가 포함된 배열
	        String[] answer = {};
	        
	        length = tickets.length; // 티켓의 개수
	        
	        visited = new boolean[length]; // 티켓 사용(방문) 여부 
	        list = new ArrayList<>(); // 여태 이동한 경로를 저장
	        
	        dfs("ICN", "ICN", tickets, 0); // ICN 에서 시작, 초기 이동 횟수 0 으로 초기화
	        
	        Collections.sort(list); // 알파벳 순으로 정렬
	        // route = ICN SFO ATL ICN ATL SFO -> ICN, ATL, ICN, SFO, ATL, SFO
	        answer = list.get(0).split(" ");
	        
	        return answer;
	    }
	    
	    public void dfs(String start, String route, String[][] tickets, int count){
	    	// [1-1] start = ICN, route = ICN, count = 0
	    	// [1-2] start = SFO, route = ICN SFO, count = 1
	    	// [1-3] start = ATL, route = ICN SFO ATL, count = 2
	    	// [1-4] start = ICN, route = ICN SFO ATL ICN, count = 3
	    	// [1-5] start = ATL, route = ICN SFO ATL ICN ATL, count = 4
	    	
	        if (count==length){ // 이동한 횟수와 티켓의 개수가 같으면 모든 경로를 다 이동한 것이므로 끝난다.
	        // [4] count = 5 와 티멧의 개수가 동일하므로 경로를 리스트에 추가한다.
	        	
	            list.add(route); // 끝난 시점의 경로를 list 에 추가 한다.
	            // [5] route = ICN SFO ATL ICN ATL SFO
	            return;
	        }
	        for (int i = 0; i<length; i++){ // 티켓의 개수만큼 
	            if(!visited[i] && start.equals(tickets[i][0])){ // start(현재위치) 가 tickets[i][0](출발지) 가 같거나 , 갔던 곳이 아니면
	            	// [2-1] ICN -> SFO visited[0] = true 로
	            	// [2-2] SFO -> ATL visited[2] = true 로
	            	// [2-3] ATL -> ICN visited[3] = true 로
	            	// [2-4] ICN -> ATL visited[1] = true 로
	            	// [2-5] ATL -> SFO visited[4] = true 로
	            	
	                visited[i] = true; // 이동해서 방문 처리
	                
	                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, count+1); // 도착지, 현재 까지 경로에 + 도착지를 추가한다, 이동 횟수+1
	                // [3-1] dfs(SFO, ICN SFO, tickets, 1) 호출
	                // [3-2] dfs(ATL, ICN SFO ATL, tickets, 2) 호출
	                // [3-3] dfs(ICN, ICN SFO ATL ICN, tickets, 3) 호출
	                // [3-4] dfs(ATL, ICN SFO ATL ICN ATL, tickets, 4) 호출
	                // [3-5] dfs(SFO, ICN SFO ATL ICN ATL SFO, tickets, 5) 호출
	                
	                visited[i] = false; // 백트래킹 다음 경로 시 재사용을 위하여 
	                // visited[4] = false 로 되돌려서 티켓 재사용 , but 이미 모든 경로를 탐색 했기에 종료
	            }
	        }
	    }
	}

