package boj.p2630_색종이만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2630 {
	static int[][] paper;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		        
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N]; 
        for(int j = 0;j < N; j++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());                       
        	for(int i = 0; i < N; i++) {        		
        		paper[j][i] = Integer.parseInt(st.nextToken()); 
        	}
        }
        
        cut(0,0,N);
        
        System.out.println(cnt);
	}
	
	static void cut(int y, int x, int N) {
		if(N == 1) {
			cnt++;
			return;
		}				
		
		//모두 같은 색으로 칠해져 있는지 확인, 다르면 1/4으로 나눠서 4개 호출
		int tmp = paper[y][x];
		for(int i = y; i < y + N; i++ ) {
			for(int j = x; j < x + N; j++ ) {
				if(paper[i][j] != tmp ) {
					//이렇게 부르면, 안맞는 그 순간 마다 계속 자름 중복해서, 
					cut(y,x,N/2);
					cut(y+N/2, x, N/2);
					cut(y, x+N/2, N/2);
					cut(y+N/2, x+N/2, N/2);
				}
				if(j== x+N-1 && i == y+N-1) {
					cnt++;
					break;
				}
			}
		}
		
		
	}
}
