/*
 * - 접근/아이디어
    - 단순 오름차순, 내림차순이 아님 [6, 10, 1] 내림차순 시 1061
    - 서로 숫자를 연결했을때 더 큰 수를 뽑아야함[6, 10, 1] 일 경우, 1061 보다 6110 더큼
    - “6” + “10” = 610 > 106 : 6이 10보다 앞에 위치 해야함
    - “10” + “1” = 110 >  101 : 1이 10보다 앞에 위치 해야함
    - “6”, “1”, “10” 순으로 최종 배치 되어야함
    - 0만 존재하는 경우는 생각하지 못함
 */

package Programmers.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class p_가장큰수 {

	    public static void main(String[] args) throws IOException {
	        // BufferedReader로 입력 받기
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        // 첫 번째 줄 입력값 받기
	        String[] input = br.readLine().split(" "); // 공백을 기준으로 나누어 배열에 저장
	        int[] numbers = new int[input.length];
	        
	        for (int i = 0; i < input.length; i++) {
	            numbers[i] = Integer.parseInt(input[i]); // 입력받은 숫자들을 정수형 배열로 변환
	        }
	        
	        // Solution 클래스의 solution 메서드를 호출하여 결과 출력
	        Solution solution = new Solution();
	        System.out.println(solution.solution(numbers));
	    }
	}

class Solution {
    public String solution(int[] numbers) {
        
        // 정수형 배열을 문자열 배열로 작성
        ArrayList<String> list = new ArrayList<>(); // ArrayList 동적으로 크기 조정 가능, 제네릭 사용으로 다양한 타입 적용
        for ( int number : numbers) { // forearch 문 number에 numbers 배열의 값을 할당
            list.add(String.valueOf(number)); // String.valueOf 으로 number를 문자열로 변환 하여 add(추가)
        }
        
        list.sort((o1, o2) -> { // 리스트 요소 문자열 o1, o2 를 비교하여 정렬
            int a = Integer.parseInt(o1 + o2); // o1="6" o2="10" 일 경우 o1+o2 = "610" 이며 해당 문자열을 정수로 변환
            int b = Integer.parseInt(o2 + o1); // o2="10" o1 ="6" 일 경우 o1+o2 = "106"
            return Integer.compare(b, a); // (b, a)는 내림차순 의미 , b:30 > a:20 인 경우 b가 a보다 앞에 위치
										  // a=610, b=106 일 경우 b:106 < a:610 으로 b가 a보다 뒤에 위치   
        });
        
        // 정수로 내림차순된 것을 문자열로 만든다.
        StringBuilder sb = new StringBuilder();
        
        for ( String s : list) { //list (정수형)을 s에 할당
            sb.append(s); // 문자열을 나열
        }
        
        // 0으로만 이루어진 경우 0으로 출력한다. (생각하지 못했던 부분)
        return sb.charAt(0) == '0' ? "0" : sb.toString(); // 삼항연산자 제일 앞에 있는게 0인 경우 0 반환 아닌 경우, StringBuilder 의 sb 문자열 반환
        }
}
