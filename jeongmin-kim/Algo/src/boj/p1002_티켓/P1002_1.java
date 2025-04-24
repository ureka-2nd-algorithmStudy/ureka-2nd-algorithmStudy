package boj.p1002_티켓;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1002_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int dx = x1 - x2;
            int dy = y1 - y2;
            double dist = Math.sqrt(dx * dx + dy * dy);

            if (dist == 0) {
                if (r1 == r2) System.out.println(-1);  // 같은 위치, 같은 반지름
                else System.out.println(0);            // 같은 위치, 다른 반지름
            } else if (dist == r1 + r2 || dist == Math.abs(r1 - r2)) {
                System.out.println(1);  // 접점 1개
            } else if (Math.abs(r1 - r2) < dist && dist < r1 + r2) {
                System.out.println(2);  // 접점 2개
            } else {
                System.out.println(0);  // 만나지 않음
            }
        }
    }
}
