package algo.study.week6_2;

import java.io.*;
import java.util.*;

public class 콘센트 {
    static PriorityQueue<Integer> pQ = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) pQ.offer(Integer.parseInt(st.nextToken()));

				// 전자기기 개수가 콘센트 수보다 적은 경우가 있음
				// 이때는 단순히 가장 오래걸리는 시간이 정답
        if(pQ.size() < m) {
            System.out.println(pQ.poll());
            return;
        }
				
				// 콘센트 길이만큼 배열을 만들고
				// 가장 오래걸리는 기기부터 배치
        int[] arr = new int[m];
        for(int i=0;i<m;i++) arr[i] += pQ.poll();

        while(!pQ.isEmpty()){
		        // 콘센트에서 최소 인덱스 찾기
            int minIdx = 0;
            for(int i=0;i<m;i++){
                if(arr[i] < arr[minIdx]) minIdx = i;
            }
						
						// 찾은거에 다음 값 더해주기
            arr[minIdx] += pQ.poll();
        }
				
				// 모든 콘센트에서 가장 오래 걸린 시간이 
				// 모든 기기를 충전할 수 있는 최소 시간
        int answer = Arrays.stream(arr).max().getAsInt();

        System.out.println(answer);
    }
}
