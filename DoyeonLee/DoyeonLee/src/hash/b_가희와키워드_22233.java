package hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class b_가희와키워드_22233 {

	public static void main(String ags[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
//		N 개의 문자열 배열을 입력 받고 1줄에 1문자
//		그 아래 M 개의 문자열 배열을 입력 받고 1줄에 여러 문자가능
//		
//		N개의 문자열을 hash 에 다 넣고 // keywords.add(br.readLine());
//		M 개의 문자열에서 각 문자열이
//		위의 Hash 에 동일한게 있으면 hash 에서 동일한 값 remove 이때 Hash 에 남은 문자 개수 세기 // keywords.remove(Awrittenword);
//		그렇게 계속 M 에 있는 문자열을 Hash 에 있는 문자열과 비교해서 남아있는 문자 개수 세기 
//		ex) 만약에 A 라는 단어가 원래 Hash 에 있었는데 M 의 문자로 인해서 A라는 단어가 제거 됐으면 그 상태로 다음 문자열 비교
//			즉 다음 문자 비교할때 hash 이 초기화 되어  A가 다시 추가된 상태로 조회하지 않는다.
			
		HashSet<String> keywords = new HashSet<>();
		
		for ( int i = 0; i < N; i++) { // N개의 키워드 입력 받기
			keywords.add(br.readLine());	
		}
		

		for ( int i = 0; i < M; i++) { // M 개의 문자열
			String[] writtenwords = br.readLine().split(","); // 쓰이는 문자 , 로 구분
			for ( String Awrittenword : writtenwords) {
				keywords.remove(Awrittenword); // AWrittenword 가 keywords에 있으면 삭제
			}
			
			System.out.println(keywords.size()); // 남아있는 단어 개수 세기
		}
		
	}
			
	
}

/*
5 2
map
set
dijkstra
floyd
os
map,dijkstra
map,floyd
*/

