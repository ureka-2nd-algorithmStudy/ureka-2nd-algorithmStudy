package pr.solution_피로도_재귀;

public class Solution {  
    static boolean[] visited;  
    static int count = 0;  
  
    public int solution(int k, int[][] dungeons) {  
        visited = new boolean[dungeons.length];  
        dfs(0, k, dungeons);  
        return count;  
    }  
      
    private void dfs(int depth, int fatigue, int[][] dungeons){  
        for (int i = 0; i < dungeons.length; i++){  
		        //방문하였거나, 던전의 소모 피로도가 현재 피로도보다 크면 넘어가기
            if (visited[i] || dungeons[i][0] > fatigue) {  
                continue;  
            }  
            visited[i] = true;  
            dfs(depth + 1, fatigue - dungeons[i][1], dungeons);  
            visited[i] = false;  
        }  
        count = Math.max(count, depth);  
    }  
}