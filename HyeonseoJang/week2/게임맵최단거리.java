import java.util.*;

class 게임맵최단거리 {
    static class Point{
        int x,y;
        Point(int y, int x){
            this.y = y; this.x = x;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 1;
        int[] dy = {-1,0,1,0};
        int[] dx = {0,1,0,-1};
        Queue<Point> qu = new ArrayDeque<>();   
        qu.offer(new Point(0,0));
        // 4방탐색이므로 자신이 온곳은 다시 오지못하게
        // 즉, 무한루프에 빠지지 않게 그냥 벽으로 처리
        maps[0][0] = 0;
        
        while(!qu.isEmpty()){
            int len = qu.size();
            for(int i=0;i<len;i++){
                Point now = qu.poll();
                if(now.y == maps.length-1 && now.x == maps[0].length-1) return answer;
                for(int j=0;j<4;j++){
                    int ny = now.y+dy[j];
                    int nx = now.x+dx[j];
                    if(ny>=0 && ny < maps.length && nx >=0 && nx < maps[0].length && maps[ny][nx] == 1){
                        maps[ny][nx] = 0;
                        qu.offer(new Point(ny,nx));
                    }
                }
            }
            answer++;
        }
        
        return -1;
    }
}