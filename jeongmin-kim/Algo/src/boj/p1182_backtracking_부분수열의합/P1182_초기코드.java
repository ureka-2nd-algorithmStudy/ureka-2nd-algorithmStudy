package boj.p1182_backtracking_부분수열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class P1182_초기코드 {
	static boolean[] visited;
	static int answer;
	static ArrayList<String> routes;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		visited = new boolean[N];
		routes = new ArrayList<String>();
		
		//dfs 호출
		for(int i = 0; i < N;i ++) {
			visited[i] = true;
			dfs(arr,arr[i],S,Integer.toString(arr[i]) );
			visited[i] = false;
		}
		
		
		//routes에서 동일한 것들은 같이 취급하는 작업 
		Set<List<Integer>> uniqueRoutes = new HashSet<>();
		for (String route : routes) {
            // 문자열을 공백 기준으로 분할하여 배열로 변환
            String[] splitRoute = route.split(" ");
            int[] intArray = new int[splitRoute.length];

            for (int i = 0; i < splitRoute.length; i++) {
                intArray[i] = Integer.parseInt(splitRoute[i]);
            }

            // 정렬하여 동일한 배열을 같은 것으로 인식
            Arrays.sort(intArray);

            // Java 8~15: int[]을 List<Integer>로 변환
            List<Integer> routeList = Arrays.stream(intArray)
                                            .boxed()
                                            .collect(Collectors.toList());

            uniqueRoutes.add(routeList);
        }       
		 		 

        // 결과 출력 (고유한 배열의 개수)
		System.out.println(uniqueRoutes.size());
	} 
	
	static void dfs(int[] arr, int sum, int S, String route) {	
		
		if(sum == S) {
			answer++;
			routes.add(route);
			System.out.println(route);
			return;
		}
		
		for(int i = 0; i < arr.length; i ++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(arr, sum+arr[i],S,route+" "+Integer.toString(arr[i]));
				visited[i] = false;
			}
		}
		
		
	}
	
}
