package algo.basic.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

		// 각 단어가 몇번 등장했는지 기록하기 위한 map
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            String tmp = br.readLine();
            // 길이가 m 이상인 단어만 기록
            if(tmp.length() >= m) 
	            map.put(tmp, map.getOrDefault(tmp,0) +1);
        }
		
        List<String> keyList = new ArrayList<>(map.keySet());
        
        Collections.sort(keyList, (a,b) -> {
		    // 우선순위 1.자주 나오는 단어 순으로 내림차순
            if(map.get(a) != map.get(b)) return map.get(b) - map.get(a);
            // 우선순위 2.문자열의 길이 순서대로 내림차순 
            else if(a.length() != b.length()) return b.length() - a.length();
            // 우선순위 3.알파벳 사전순으로 정렬 
            else return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        keyList.stream().forEach(a -> sb.append(a).append("\n"));
        System.out.println(sb);
    }
}