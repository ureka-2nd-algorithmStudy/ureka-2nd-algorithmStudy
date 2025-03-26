package binarySearch;

import java.util.Arrays;

public class p_모음사전 {
	
	class Solution {
	    public int solution(String word) {
	        // 'A', 'E', 'I', 'O', 'U'의 순서를 배열로 저장
	        char[] words = {'A', 'E', 'I', 'O', 'U'};
	        // 각 자리수별 가중치 (사전에서 몇 번째로 등장하는지 계산)
	        int[] weight = {781, 156, 31, 6, 1};  // 5^4 + 5^3 + 5^2 + 5^1 + 1
	        
	        int result = 0;
	        
	        for (int i = 0; i < word.length(); i++) {
	            // 현재 문자의 인덱스(A=0, E=1, I=2, O=3, U=4)
	            int index = Arrays.binarySearch(words, word.charAt(i));
	            // 해당 자리수의 가중치를 곱해서 더함
	            result += index * weight[i] + 1;
	        }
	        
	        return result;
	    }
	}

}
