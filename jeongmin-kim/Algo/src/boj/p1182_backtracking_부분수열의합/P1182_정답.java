package boj.p1182_backtracking_부분수열의합;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1182_정답 {
    static boolean[] visited;
    static int answer;
    static int N, S;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        visited = new boolean[N];

        // DFS 탐색 시작
        dfs(arr, 0, 0, "");

        // 공집합 제외
        if (S == 0) answer--;

        System.out.println(answer);
    }

    static void dfs(int[] arr, int start, int sum, String route) {
        if (sum == S) {
            answer++;            
        }

        for (int i = start; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(arr, i + 1, sum + arr[i], route + " " + arr[i]);
                visited[i] = false;
            }
        }
    }
}
