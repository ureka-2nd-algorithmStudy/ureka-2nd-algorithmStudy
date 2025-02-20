package pr.solution_게임맵최단거리_bfs;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    static Queue<Node> queue = new ArrayDeque<>();
    static int answer;
    
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static boolean[][] visit;
    
    public int solution(int[][] maps) {        
        
        Node initLoc = new Node(0,0);                        
        visit = new boolean[maps.length][maps[0].length];
        
        bfs(initLoc, maps);
        return answer;
    }
    static class Node{
        int x;
        int y;
        
        public Node(int y, int x){
            this.x = x;
            this.y = y;
        }
    }
    
    void bfs(Node node,int[][] map){
        queue.offer(node);
        visit[node.y][node.x] = true;
        while(!queue.isEmpty()){
            Node node1 = queue.poll();
            answer++;        
            System.out.println(node1.y + " " + node1.x);
            if(node1.x == map.length -1 && node1.y == map[0].length -1){
                return;
            }
            for(int d = 0; d < 4; d++){
                int ny = node1.y + dy[d];
                int nx = node1.x + dx[d];
                if(ny < 0 || ny >= map.length || nx < 0 || nx >= map[0].length || visit[ny][nx]) continue;
                
                if(map[ny][nx] == 1){                                                             
                    queue.offer(new Node(ny, nx));
                    //System.out.println("===========");
                    //System.out.println(node1.y + "parent " + node1.x);
                    //System.out.println(ny + "child " + nx);                    
                    
                    System.out.println("===========");
                    visit[ny][nx] = true;
                }
                
            }
        }        
    }
}
