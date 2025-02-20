import java.io.*;

public class 적록색약{
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        for(int i=0;i<N;i++){
            String tmp = br.readLine();
            map[i] = tmp.toCharArray();
        }

        int normalCnt=0;
        int specialCnt = 0;

        // 적록색맹이 아닌사람 start
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    char target = map[i][j];
                    DFS(i,j, target);
                    normalCnt++;
                }
            }
        }

        // 적록색맹인 사람도 다시 카운트 해야 하므로 visited 배열 초기화
        visited = new boolean[N][N];
        // 적록색맹인 사람은 G를 R로 바꾸어 탐색하기
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j] == 'G') map[i][j] = 'R';
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    char target = map[i][j];
                    DFS(i,j, target);
                    specialCnt++;
                }
            }
        }

        System.out.println(normalCnt + " " + specialCnt);
    }

    private static void DFS(int y, int x, char target) {
        visited[y][x] = true;
        for(int i=0;i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >=0 && ny <N && nx >=0 && nx < N && !visited[ny][nx] && map[ny][nx] == target){
                DFS(ny,nx, target);
            }
        }
    }
}