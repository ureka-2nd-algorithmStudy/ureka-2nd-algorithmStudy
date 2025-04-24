package boj.p1002_티켓;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		List<int[]> testCases = new ArrayList<>();
		
		for(int i = 0; i < T; i++) {
			int[] input = new int[6];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 6; j++) {
				input[j] = Integer.parseInt(st.nextToken());
			}
			testCases.add(input);
		}
		
		
		//위치와 거리가 같을 경우 => -1
		
		 
		for(int i = 0; i < T; i++) {			
			int r1 = testCases.get(i)[2];
			int r2 = testCases.get(i)[5];
			int x1 = testCases.get(i)[0];
			int y1 = testCases.get(i)[1];
			int x2 = testCases.get(i)[3];
			int y2 = testCases.get(i)[4];
			
			int dist = (int)Math.sqrt((int) Math.pow(Math.abs(x1-x2),2) + (int) Math.pow(Math.abs(y1-y2),2));
			if(dist == 0) {
				if(r1 != r2) System.out.println(0);
				else System.out.println(-1);				
				continue;
			}
			if(dist < r1 + r2) System.out.println(2);
			else if(dist == r1 + r2) System.out.println(1);			
		}
	}
}
