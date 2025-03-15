package boj.p2470_이분탐색_두용액;

import java.io.*;
import java.util.*;

public class P2470_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 정렬 (오름차순)
        
        int left = 0, right = N - 1;
        int minSum = Integer.MAX_VALUE;
        int ans1 = 0, ans2 = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
           
            // 합이 0보다 크면 오른쪽 값을 줄이고, 0보다 작으면 왼쪽 값을 증가
            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(ans1 + " " + ans2);
    }
}
