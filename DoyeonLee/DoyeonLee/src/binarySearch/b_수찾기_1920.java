package binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b_수찾기_1920 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] nArr = new int[N];
		String[] nInput = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			nArr[i] = Integer.parseInt(nInput[i]);
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] mArr = new int[N];
		String[] mInput = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			mArr[i] = Integer.parseInt(mInput[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for ( int i = 0;  i < M; i ++) {
			boolean same = false;
			for ( int j = 0; j < N; j++) {
				if (mArr[i] == nArr[j]) {
					same = true;
				}
			}
		
			sb.append(same ? "1\n" : "0\n");
		}
		
		System.out.println(sb.toString());
		
	}
}
