package boj.p2579;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2579 {
	
	static int[] stairInfo;
	static int maxCnt;
	public static void main(String[] args) throws Exception{
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int stairCnt = Integer.parseInt(br.readLine());
		stairInfo = new int[stairCnt+1];
		for(int i = 1; i <= stairCnt; i++) {
			stairInfo[i] = Integer.parseInt(br.readLine());			
		}
		maxCnt = 0;
		int answer = getScore(stairCnt); 
		
		System.out.println(answer);	
	}
	
	static int getScore(int stair) {
		
		if(stair == 1 ) {
			return stairInfo[1];
		}
		if(stair == 2){
			return stairInfo[2];
		}
		int max = stairInfo[stair]+Math.max(getScore(stair-1),getScore(stair-2));
		System.out.println(max);
		return max;
	}
}
