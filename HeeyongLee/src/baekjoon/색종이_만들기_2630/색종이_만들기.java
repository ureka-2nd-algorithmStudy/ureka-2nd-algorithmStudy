package baekjoon.색종이_만들기_2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이_만들기 {
    static int[][] board;
    static int white;
    static int blue;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 풀이
        divide(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    static void divide(int x, int y, int size) {
        if (checkColor(x, y, size)) {
            if (board[x][y] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        // 재귀 호출
        int divideSize = size / 2;
        divide(x, y, divideSize); // 2 사분면
        divide(x, y + divideSize, divideSize); // 1 사분면
        divide(x + divideSize, y, divideSize); // 3 사분면
        divide(x + divideSize, y + divideSize, divideSize); // 4 사분면
    }

    static boolean checkColor(int x, int y, int size) {
        int color = board[x][y]; // 체크를 시작할 때 기준이 되는 색깔

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (board[i][j] != color) { // color 와 색깔이 다르면 false를 반환
                    return false;
                }
            }
        }
        return true;
    }
}
