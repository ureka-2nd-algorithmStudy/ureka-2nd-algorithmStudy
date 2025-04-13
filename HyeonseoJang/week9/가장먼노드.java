import java.util.*;

class Solution {
    static List<ArrayList<Integer>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] edge) {
        for(int i=0;i<=n;i++) graph.add(new ArrayList<>());
        
        for(int[] arr : edge){
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }
        
        return BFS();
    }
    
    private int BFS(){
        Queue<Integer> qu = new ArrayDeque<>();
        boolean[] ch = new boolean[graph.size()];
        
        qu.offer(1);
        ch[1] = true;

        while(!qu.isEmpty()){
            int size = qu.size();
            boolean isInsert = false;
            int cnt = 0;
            
            for(int i=0;i<size;i++){
                int now = qu.poll();
                cnt++;
                
                for(int next : graph.get(now)){
                    if(!ch[next]){
                        isInsert = true;
                        ch[next] = true;
                        qu.offer(next);
                    }
                }
            }
            
            if(!isInsert){
                return cnt;
            }
        }
        return 0;
    }
}