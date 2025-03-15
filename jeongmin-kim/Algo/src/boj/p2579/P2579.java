package boj.p2579;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2579 {
	
	static int[] stairInfo;
	
	public static void main(String[] args) throws Exception{
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int stairCnt = Integer.parseInt(br.readLine());
		stairInfo = new int[stairCnt+1];
		for(int i = 1; i <= stairCnt; i++) {
			stairInfo[i] = Integer.parseInt(br.readLine());			
		}
		
		int answer = getScore(stairCnt,0); 
		
		System.out.println(answer);	
	}
	
	
	static int getScore(int stair, int serial) {
		
		//if 3번 연속이면 , 버리기
		if(serial >= 2){ // 계쏙 3번 연속 계단을 밟는 다는 것은 serial이 2까지 올라간다는 건데 3인줄 알고 6 -> 4 -> 3 -> 2 경우를 못막아냄						
//			System.out.println(stair + "asdfasdf");
			return 0;
		}
				
		if(stair == 1 ) {
//			System.out.println(stair + " " + stairInfo[1]);
			return stairInfo[1];
		}
		
		if(stair == 0){					
//			System.out.println(stair+ " " + stairInfo[0] +" ");
			return stairInfo[0];
		}
				
//		System.out.println(stair + " " + stairInfo[stair] + " " + serial);
		int max = stairInfo[stair] + Math.max( getScore(stair-2,serial),getScore(stair-1,++serial));
		
		return max;
	}
}
/*
6
10
20
15
25
10
20
*/
