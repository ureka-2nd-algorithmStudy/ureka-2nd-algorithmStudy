package boj.p2630_색종이만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2630_gpt {
    static int[][] paper;
    static int whiteCnt = 0;  // 하얀색(0)의 개수
    static int blueCnt = 0;   // 파란색(1)의 개수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int j = 0; j < N; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {                
                paper[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        cut(0, 0, N);

        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }

    static void cut(int y, int x, int N) {
        int color = paper[y][x];
        boolean same = true;

        // 현재 영역이 모두 같은 색인지 확인
        for (int i = y; i < y + N; i++) {
            for (int j = x; j < x + N; j++) {
                if (paper[i][j] != color) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }

        // 모두 같은 색이면 개수 증가 후 종료
        if (same) {
            if (color == 0) {
                whiteCnt++;
            } else {
                blueCnt++;
            }
            return;
        }

        // 4개의 영역으로 나누어 재귀 호출        
        cut(y, x, N / 2);
        cut(y, x + N / 2, N / 2);
        cut(y + N / 2, x, N / 2);
        cut(y + N / 2, x + N / 2, N / 2);
    }
}
