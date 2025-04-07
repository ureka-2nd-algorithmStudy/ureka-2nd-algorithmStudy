package baekjoon.집합_11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int bitSet = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            int num;

            switch (operation) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    bitSet |= (1 << (num - 1));
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    bitSet &= ~(1 << num - 1);
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    sb.append((bitSet & (1 << num - 1)) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    bitSet ^= (1 << (num - 1));
                    break;
                case "all":
                    bitSet |= (~0);
                    break;
                case "empty":
                    bitSet &= 0;
                    break;
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}
