package boj.p1914_하노이탑_재귀;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class p1914 {
	static int cnt;
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        if(N<20) {
        	hanoi(N,1,3);
        }
                 
        System.out.println(cnt);
    }
    
    static void hanoi(int n, int start, int end){
    	//기저 조건
		if(n == 0) {
			return;
		}
		
		//n-1개 옮기기
		hanoi(n-1, start, 6 - start - end);
    	//1개 옮기기
		cnt++;
		System.out.print(start);
		System.out.print(" ");
		System.out.println(end);
		hanoi(n-1, 6-start-end,end );
    	
    }

}