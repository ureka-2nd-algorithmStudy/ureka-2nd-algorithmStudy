package boj.p1463_1로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1463_2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
		if(N == 1) {
			 System.out.println(1);
			 return;
		}
		int cnt[] = new int[(int)(N+1)]; //0:dummy
		
		cnt[1] = 0;
		cnt[2] = 1;
		cnt[3] = 1;
		
		for(int i = 4; i <= N; i++) {
			if(i % 3 == 0 && i % 2 ==0) {
				cnt[i] = getMin(cnt[i/2], cnt[i/3], cnt[i-1]) + 1;
				continue;
			}
			if(i % 3 == 0 && i % 2 == 1) {
				cnt[i] = getMin(cnt[i/3], cnt[i-1]) + 1;
				continue;
			}
			if(i % 3 == 1 && i % 2 == 0){
				cnt[i] = getMin(cnt[i/2], cnt[i-1]) + 1;
				continue;
			}
			
			cnt[i] = cnt[i-1]+1;
			
		}
		
		System.out.println(Arrays.toString(cnt));
		
		System.out.println(cnt[(int)N]);
//		System.out.println(cnt[N/2]);
//		System.out.println(cnt[N-1]);
	}
	
	
	static int getMin(int a, int b, int c) {
		int min = a;
		
		if(a > b) {
			if(b>c) {
				min = c;
			}else {
				min = b;
			}						
		}else {
			if( a > c) min = c;
		}
		
		return min;
	}
	
	static int getMin(int a, int b) {
		return (a<b ? a:b);
	}
}
