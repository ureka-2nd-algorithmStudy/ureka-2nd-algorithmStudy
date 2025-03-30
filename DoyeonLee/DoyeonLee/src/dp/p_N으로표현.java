package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class p_N으로표현 {

	public int solution(int N, int number) {
		if ( N == number) return 1; // N 이 number와 같다면 한번만 사용하면 되는 것으로 바로 1 반환

	List<Set<Integer>> dp = new ArrayList<>();
	for ( int i = 0; i <= 8; i++) { // dp[i] 는 i 번 사용해서 만들 수 있는 숫자 저장
		dp.add(new HashSet<>()); // N 을  i 번 사용하여 만들 수 있는 숫자들의 집합  / 중복된 숫자 저장하지 않도록 한다.
	}
	
	for ( int i = 1; i <= 8; i++) { // 사칙연산 없이 숫자 만으로 가능한 경우
		int num = Integer.parseInt(String.valueOf(N).repeat(i));
		dp.get(i).add(num); // 숫자 N 을 문자열로 변환
		// 5.repeat(1) "1" / 5.repeat(3) "555"
	}
	
	// 사칙연산
	for (int i = 1; i <= 8; i++) { // i = 2
	    for (int j = 1; j < i; j++) { // j = 1
	        for (int a : dp.get(j)) { // dp.get(1) = {5}
	            for (int b : dp.get(i - j)) { // dp.get(1) = { 5}
	                dp.get(i).add(a + b); // 5+5 = 10
	                dp.get(i).add(a - b); // 5 -5 = 0
	                dp.get(i).add(a * b); // 5 * 5 = 25
	                if (b != 0) dp.get(i).add(a / b); // 5/5 = 1  // dpget(2) = {55, 10, 0 , 25} 저장
	            }
	        }
	    }
	}
	    
	   return -1;
	
	}
}
