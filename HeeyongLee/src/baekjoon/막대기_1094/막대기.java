package baekjoon.막대기_1094;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 막대기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int cnt = 0;
        if (target == 64) {
            System.out.println(cnt);
            return;
        }
        for (int i = 0; i <= 6; i++) {
            if ((target & (1<<i)) != 0) cnt++;
        }
        System.out.println(cnt);
    }
}
