package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_회의실배정_1931 {
	
	static int N;
	static List<int[]> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	
    	
    	for(int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		
    		int start = Integer.parseInt(st.nextToken());
    		int end = Integer.parseInt(st.nextToken());
    		
    		list.add(new int[] {start, end});
    	}
    	
    	// 회의가 빨리 끝나는 순, 같다면 빨리 시작하는 순으로 정렬
    	Collections.sort(list, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
    	
    	int cnt = 1;
    	int en = list.get(0)[1]; 
    	int size = list.size();
    	
    	for(int i = 1; i < size; i++) {
    		if(list.get(i)[0] >= en) { // 회의의 시작 시간이 현재 종료 시간보다 크거나 같다면 회의 가능
    			cnt++;
    			en = list.get(i)[1]; // 종료 시간 갱신
    		}
    	}
    	
    	System.out.println(cnt);
	}
	
}
