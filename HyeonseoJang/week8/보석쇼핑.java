import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {0, gems.length-1};
        
        // 보석의 종류를 저장하는 set
        Set<String> gemType = new HashSet<>();
        for(String ss:gems) gemType.add(ss);
        
        // 보석의 종류 수    
        int target = gemType.size();
        
        int lt = 0, rt = 0;
        int min = Integer.MAX_VALUE;
        
        // 카운팅을 위한 맵
        Map<String, Integer> cntMap = new HashMap<>();  
        
        for(;rt<gems.length;rt++){
            cntMap.put(gems[rt], cntMap.getOrDefault(gems[rt], 0)+1);
            
            // 모든 종류의 보석이 슬라이딩 윈도우에 들어오면 앞에서부터 범위를 줄여나가기
            for (; cntMap.size() == target; lt++) {
		            // 최소범위면 정답으로 일단 기록
                if (rt - lt < min) {
                    min = rt - lt;
                    answer[0] = lt + 1; 
                    answer[1] = rt + 1;
                }
									
								// 카운팅 했던거 빼고 카운트 횟수가 0이면 맵에서 엔트리 제거
                cntMap.put(gems[lt], cntMap.get(gems[lt]) - 1);
                if (cntMap.get(gems[lt]) == 0) cntMap.remove(gems[lt]); 
            }
        }
        
        return answer;
    }
}