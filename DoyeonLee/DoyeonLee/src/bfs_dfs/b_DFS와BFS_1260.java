/*
 [문제요약]

그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성

정점 여러 개일 경우 정점 수 작은 거 부터 방문

- N = 정점의 개수 / M= 간선의 개수 / V= 시작 정점
- boolean[] visited = 방문 여부를 확인하는 배열
- List graph : 그래프 인접 리스트로 표현
- 방문여부 확인
- DFS 재귀/BFS queue
 */

package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_DFS와BFS_1260 {

	    static boolean[] visited; // 방문 여부를 확인하는 배열
	    static List<Integer>[] graph; // 그래프를 인접 리스트로 표현

	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
	        int M = Integer.parseInt(st.nextToken()); // 간선의 개수
	        int V = Integer.parseInt(st.nextToken()); // 시작 정점
	        
	        graph = new ArrayList[N + 1]; // 1번부터 N번까지 정점이므로 N+1 크기의 리스트 생성
	        visited = new boolean[N + 1]; // 방문 여부 배열
	        
	        // 그래프 초기화
	        for (int i = 1; i <= N; i++) {
	            graph[i] = new ArrayList<>();
	        }

	        // 간선 정보 입력받기
	        for (int i = 0; i < M; i++) {
	            st = new StringTokenizer(br.readLine());
	            int a = Integer.parseInt(st.nextToken());
	            int b = Integer.parseInt(st.nextToken());
	            graph[a].add(b); // 양쪽 다 연결
	            graph[b].add(a);
	        }

	        // 각 정점의 인접 리스트를 오름차순으로 정렬 (정점 번호가 작은 순으로 방문)
	        for (int i = 1; i <= N; i++) {
	            Collections.sort(graph[i]);
	        }

	        // DFS 수행
	        Arrays.fill(visited, false); // 방문 배열 초기화
	        dfs(V);
	        System.out.println();

	        // BFS 수행
	        Arrays.fill(visited, false); // 방문 배열 초기화
	        bfs(V);
	    }

	    // DFS 함수
	    public static void dfs(int v) {
	        visited[v] = true; // v번째 정점 방문 처리
	        System.out.print(v + " "); // 현재 정점 출력
	        
	        for (int next : graph[v]) { // 정점v와 연결된 모든 정점(next) 을 순차적으로 확인
	            if (!visited[next]) {
	                dfs(next); // 아직 방문하지 않은 정점이라면 DFS 재귀 호출
	            }
	        }
	    }

	    // BFS 함수
	    public static void bfs(int v) {
	        Queue<Integer> queue = new LinkedList<>();
	        queue.offer(v); // 시작 정점 큐에 넣기
	        visited[v] = true; // v번째 정점 true 로 설정 v는 큐에 들어가면서 방문 처리 
	        
	        while (!queue.isEmpty()) { // 큐에 탐색할 정점이 있을 때만 반복분 실행
	            int current = queue.poll(); // 큐에서 정점을 꺼내고 그 값 반환
	            System.out.print(current + " "); // 꺼낸 정점들 차례로 출력, 현재 정점 출력
	            
	            for (int next : graph[current]) { // 현재 정점과, 인접한 모든 정점(next) 순차적으로 확인
	                if (!visited[next]) { // next(인접한 정점)가 아직 방문되지 않았다면 if visited[next] = false, 큐에 넣어 방문처리 
	                    visited[next] = true; // 방문 처리
	                    queue.offer(next); // 큐에 추가하여 넣은 순서대로 탐색될 예정
	                }
	            }
	        }
	    }
	}

