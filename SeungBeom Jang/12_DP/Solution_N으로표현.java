package pr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_N으로표현 {
	class Solution {
		// DP[i] : i번의 연산으로 만들 수 있는 모든 수를 Set으로 저장 (중복 제거)
	    static List<Set<Integer>> dp = new ArrayList<>();
	    
	    public int solution(int N, int number) {
	        for(int i = 0; i <= 8; i++){
	            dp.add(new HashSet<Integer>());
	        }
	        
	        int num = 0;
	        
	        // 8번이 최대
	        for(int i = 1; i <= 8; i++){
	            num = num * 10 + N;
	            dp.get(i).add(num); // 1번 5, 2번 55, 3번 555, ...
	            
	            // i = 3, j = 1, j = 2, ... : 3번 연산한 결과와 1번, 2번 연산, ... 한 결과로 만들 수 있는 결과 
	            // i = 3, j = 1 : dp(3 + 1).add(더한값, 뺀값, 곱한값, 나눈값)
	            for(int j = 1; i + j <= 8 && j <= i; j++){                        
	                for(int a : dp.get(i)){
	                    for(int b : dp.get(j)){
	                        dp.get(i + j).add(b + a);
	                        
							// 뺴기와 나누기는 순서에 따라 연산결과 달라짐
	                        dp.get(i + j).add(a - b);
	                        dp.get(i + j).add(b - a);
	                        
	                        dp.get(i + j).add(a * b);
	                        
	                        if(b != 0) dp.get(i + j).add(a / b);
	                        if(a != 0) dp.get(i + j).add(b / a);
	                    }
	                }
	            }
	            
	            // i번째 List의 Set에 number가 포함되어 있다면 i 반환
	            if(dp.get(i).contains(number))
	                return i;
	        }
	        
	        // 없다면 -1
	        return -1;
	    }
	}
}
