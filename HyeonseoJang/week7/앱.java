package algo.study.week6_2;

import java.io.*;
import java.util.*;

public class 앱 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 메모리와 코스트 배열 선언
        int[] memArr = new int[n];
        int[] costArr = new int[n];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        // 메모리와 코스트 각각 배열에 저장
        for(int i=0;i<n;i++){
            memArr[i] = Integer.parseInt(st1.nextToken());
            costArr[i] = Integer.parseInt(st2.nextToken());
        }

        // 비용 최댓값이 dp 배열의 크기
        int costSum = Arrays.stream(costArr).sum();
        // dp 배열의 인덱스값이 비용, 배열값이 최대 메모리
        int[] dp = new int[costSum+1];

        // 각 앱마다 반복
        for(int i=0;i<n;i++){
            int mem = memArr[i];
            int cost = costArr[i];

            // 기존 dp[j] 와 dp[j]에서 cost 만큼 전 에서 mem 을 더한것 중 최댓값으로 저장
            for(int j=costSum; j>=cost;j--){
                dp[j] = Math.max(dp[j], dp[j-cost]+mem);
            }
        }

        int answer = -1;
        // 가장 빠르게(비용 싸게) M 바이트 이상 확보할 수 있는 비용 answer에 저장 후 출력 
        for(int i=0;i<dp.length;i++){
            if(dp[i] >= m){
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}
