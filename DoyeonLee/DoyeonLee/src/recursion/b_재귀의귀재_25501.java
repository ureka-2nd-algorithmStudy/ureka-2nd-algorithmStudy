package recursion;

public class b_재귀의귀재_25501 {

	public static int recurcnt = 0; // recursion 호출 횟수 변수 선언
		
	public static int recursion(String s, int l, int r) {
		recurcnt++; // recursion 호출 횟수 카운트
		
		if(l >= r ) { // 5. 조건, 왼쪽 인덱스가 오른쪽 인덱스보다 같거나 크면 종료
			return 1; // palindrome 이면 1 반환
		}
		else if(s.charAt(l) != s.charAt(r)) { // 왼쪽과 오른쪽 문자열이 같지 않으면 palindrome 이 아니므로 0 반환
			return 0;
		}
		else {
			return recursion(s, l+1, r-1); // 왼쪽과 오른쪽 문자열이 같으면 가운데 쪽으로 이동하면서 다음 문자열 비교										 	
		}
	}

	public static int isPalindrome(String s) {
		recurcnt = 0; // 새 문자열 시작 시 recursion 함수 호출 횟수 0으로 초기화
		return recursion(s, 0, s.length()-1); // 문자열 비교는 (0, 문자열길이-1) 부터 시작
											  // "AAA" 인 경우 s.length() = 3 이고 3-1 이면 2 이므로 인덱스[0,1,2] 했을때 2가 제일 마지막 문자열 가리킴
	}

	public static void main(String[] args) {
		String[] testCases = {"AAA", "ABBA", "ABABA", "ABCA", "PALINDROME"};
		
		for ( String s : testCases) {
			System.out.println(isPalindrome(s) + " " + recurcnt);
		}
	}
}
		

