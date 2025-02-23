package baekjoon.로또_6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로또 {
    static int[] numbers;
    static int[] tgt = new int[6];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int numbersLength = Integer.parseInt(st.nextToken());
            if (numbersLength == 0) {
                break;
            }
            numbers = new int[numbersLength];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            combine(0, 0);
            System.out.println();
        }
    }

    private static void combine(int numberIdx, int tgtIdx) {
        StringBuilder sb = new StringBuilder();
        if (tgtIdx == tgt.length) {
            for (int i = 0; i < tgt.length; i++) {
                sb.append(tgt[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }
        if (numberIdx == numbers.length) {
            return;
        }

        tgt[tgtIdx] = numbers[numberIdx];
        combine(numberIdx + 1, tgtIdx + 1);
        combine(numberIdx + 1, tgtIdx);
    }
}
