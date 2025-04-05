package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b_분수찾기_1193 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
	
		int group = 1;
		
		while ( group * ( group + 1) / 2 < X) { // X=7 인 경우 7인 속한 그룹 찾기 (n*(n+1)) / 2 => 등차수열
			group++; // X=7 인 경우 그룹 4에 속함
		}
		
		int K = (group - 1) * group / 2; // 전  그룹(3) 의 마지막 번호(6) 구하기
		int offset = X - K; // 이번 그룹(4) 에서 몇 번째에 속하는지 구하기 (7-1 = 4그룹에서 1번째)
		
		int numerator, denominator; // 분자, 분호
		
		if ( group % 2 == 0) { // 짝수, 홀수 그룹 별 계산
			numerator = offset; // 짝수 그룹은 분자 증가, 분모 감소
			denominator = group - offset + 1;
		} else {
			numerator = group - offset + 1; // 홀수 그룹은 분자 감소, 분모 증가
			denominator = offset;
		}
		
		System.out.println(numerator + "/" + denominator);
	}

}
