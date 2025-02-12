/*
 * - 접근/아이디어
    - [1, 5, 2, 6, 3, 7, 4] i=2, j=5, k=3 -> [2, 3, 5, 6] 중 5
    - commands 는 i, j, k
	- 배열 자른 후 정렬(sort)
	
 */


package Programmers.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_K번째수 {

	public static void main(String[] args) {
		// 하드코딩
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {
				{2, 5, 3},
				{4, 4, 1},
				{1, 7, 3}	
		};
		
		p_K번째수 solution = new p_K번째수();
		int[] result = solution.solution(array, commands);
		
		//결과 출력
		for ( int value : result) { // result : solution 메서드 반환 결과, value = 반환 결과 저장
			System.out.println(value);
		}
	}


    public int[] solution(int[] array, int[][] commands) { // 원본 배열 : array, 2차원배열 : commands
    	int[] answer = new int[commands.length]; // commands : [[2,5,3],[4,4,1],[1,7,3]] -> commands.length = 3
    	
    	for( int c = 0; c < commands.length; c++) { // commands : [[2,5,3],[4,4,1],[1,7,3]] 
    		int i = commands[c][0]; // 2   4   1
    		int j = commands[c][1]; // 5   4   7
    		int k = commands[c][2]; // 3   1   3
    		
    		int[] slicedArr = Arrays.copyOfRange(array,  i - 1,  j); // copyOfRange : 원본배열, 시작인덱스(포함), 끝인덱스(미포함)
    																 // 인덱스 0번 부터 이므로 i-1
    																 // [1, 2, 3, 4, 5, 6] 에서 i=2, j=5 면 [2,3,4,5]
    																 // [0, 1, 2, 3, 4, 5] <= 인덱스 위치, i -1 = 1(포함), j=5(미포함) 이므로 [2,3,4,5] 
    		Arrays.sort(slicedArr); // 잘라낸 배열 정렬
    		
    		answer[c] = slicedArr[k - 1]; // 잘라낸 배열이 [2,3,5,6] 이면 k=3일때 3번째 원소 추출임,
    									  // 인덱스 순서 :[0,1,2,3]  0번 부터 시작이므로 k-1=2 로 지정 따라서  5 추출
    	}
    	return answer;
    }
}
        
