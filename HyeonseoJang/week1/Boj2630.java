import java.io.*;
import java.util.*;

public class Boj2630{
    // true 는 파란색, false는 하얀색으로 표현
    static boolean[][] arr;
    static int blue_cnt, white_cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = st.nextToken().equals("1");
            }
        }

        solution(0,0, N);

        System.out.println(white_cnt + "\n" + blue_cnt);
    }

    private static void solution(int y, int x, int size){
        // 1칸이면 파랑이냐 하얀색이냐 판단 후 카운트 증가
        if(size == 1){
            if(arr[y][x]) blue_cnt++;
            else white_cnt++;

            return;
        }

        int next_size = size/2;
        boolean now = arr[y][x];

        // 현재 사이즈만큼 다 똑같으면 나눠서 정복할 필요 없음
        if(isAllSameThisGround(y,x,size,now)){
            if(now) blue_cnt++;
            else white_cnt++;
        }else{ // 다르면 분할정복 시작
            for(int i=0;i<2;i++){
                for(int j=0;j<2;j++){
                    solution(y+i*next_size, x+j*next_size, next_size);
                }
            }
        }
    }

    private static boolean isAllSameThisGround(int y, int x, int size, boolean now) {
        // 주어진 좌표부터 size 만큼 검사
        for(int i=y;i<y+size;i++){
            for(int j=x;j<x+size;j++){
                if(arr[i][j] != now) return false;
            }
        }
        return true;
    }
}