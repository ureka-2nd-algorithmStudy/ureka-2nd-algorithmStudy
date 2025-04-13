import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> cntMap = new HashMap<>();
        
        for(String[] cloth: clothes){
            cntMap.put(cloth[1], cntMap.getOrDefault(cloth[1], 0) +1);
        }
        
        for(String key : cntMap.keySet()) {
            answer *= (cntMap.get(key) + 1); // 아무것도 안입는 경우까지 세줘야함
        }
        
        return answer-1; // 아무것도 안입는 경우의 수 하나 빼줘야함
    }
}