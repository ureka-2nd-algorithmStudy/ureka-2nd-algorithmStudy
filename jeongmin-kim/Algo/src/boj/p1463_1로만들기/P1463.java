package boj.p1463_1로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1463 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt[] = new int[N+1]; //0:dummy
		
		cnt[1] = 0;
		cnt[2] = 1;
		cnt[3] = 1;
		
		for(int i = 4; i <= N; i++) {
			if(i % 3 == 0) {
				cnt[i] = cnt[i/3] + 1;
			}else if(i % 3 == 1){				
				cnt[i] = ((cnt[i-1]) > (cnt[i/2]) ? (cnt[i/2]) : (cnt[i-1])) + 1;							
			}else if(i%3 == 2){
				if(i%2 == 0) {
					cnt[i] = cnt[i/2] + 1;
				}else {
					cnt[i] = cnt[i-2] + 2; 
				}				 
			}
		}
		
		System.out.println(Arrays.toString(cnt));
		
		System.out.println(cnt[N]);
		System.out.println(cnt[N/2]);
		System.out.println(cnt[N-1]);
	}
}
