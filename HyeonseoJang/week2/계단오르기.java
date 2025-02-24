package algo.study.week2_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기 {
    static int[] dy;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dy = new int[301];
        arr = new int[301];
        for(int i=1;i<=n;i++) arr[i] = Integer.parseInt(br.readLine());

        System.out.println(solution(n));
    }

    private static int solution(int n){
        dy[1] = arr[1];
        dy[2] = arr[1]+arr[2];

        for(int i=3;i<=n;i++){
            dy[i] = Math.max(dy[i-2], dy[i-3]+arr[i-1]) + arr[i];
        }
        return dy[n];
    }
}
