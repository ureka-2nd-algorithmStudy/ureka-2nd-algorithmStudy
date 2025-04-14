package boj.p16165;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P16165 {
	public static void main(String[] args) throws IOException{
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> hm = new HashMap<>();
		
		
		for(int i = 0; i < N; i++) {
			String groupName = br.readLine();
			int memberCnt = Integer.parseInt(br.readLine());
			for(int j = 0; j < memberCnt; j++) {
				hm.put(groupName, br.readLine());
			}
		}
		
//		for(int i = 0; i < M; i++ ) {
//			String name = br.readLine();
//			int problemKind = Integer.parseInt(br.readLine());
//			
//			if(problemKind == 0) {
//				for(int i = 0;'')
//				for(int i = 0; i < )
//			}
//		}
	}
}
