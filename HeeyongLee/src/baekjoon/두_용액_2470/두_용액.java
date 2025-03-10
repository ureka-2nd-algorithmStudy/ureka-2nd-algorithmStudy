package baekjoon.두_용액_2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두_용액 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = size-1;
        int answerLeft = 0, answerRight = 0;
        
        int[] arr = new int[size];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        while (end > start) {
            int sum = arr[end] + arr[start];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                answerLeft = arr[start];
                answerRight = arr[end];

                if (sum == 0) {
                    break;
                }
            }
            if (sum < 0) {
                start++;
            } else {
                end--;
            }
        }
        System.out.println(answerLeft + " " + answerRight);
    }
}
