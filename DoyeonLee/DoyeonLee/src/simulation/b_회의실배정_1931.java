package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_회의실배정_1931 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 회의 개수
		int[][] meetings = new int[n][2]; // n행 2열
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meetings[i][0] = Integer.parseInt(st.nextToken()); // 회의 시작 시간
			meetings[i][1] = Integer.parseInt(st.nextToken()); // 회의 종료 시간
		}
		
		// 종료 시간이 같으면 시작 시간 오름차순 , 종료 시간 다르면 종료 시간을 오름차순
		Arrays.sort(meetings, (a,b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
		
		int count = 0; // 회의 시간 개수를 위한 변수
		int EndTime = 0; // 이전 종료 시간 저장을 위한 변수

        for (int[] meeting : meetings) {
            if (meeting[0] >= EndTime) { // 시작 시간이 종료 시간 보다 크거나 같으면 
                count++;				 // 회의 시간 개수 추가
                EndTime = meeting[1]; // 현재 선택한 회의 종료 시간을 EndTime 에 저장한다
            }
        }

        System.out.println(count);
    }
}