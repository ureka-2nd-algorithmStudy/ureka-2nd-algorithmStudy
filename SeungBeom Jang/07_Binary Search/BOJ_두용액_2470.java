package bj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_두용액_2470 {

	static int N;
	static int[] arr;
	static int MN = Integer.MAX_VALUE;
	static int[] ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		ans = new int[2];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 이분 탐색은 정렬된 배열에서'만' 사용이 가능
		Arrays.sort(arr);
		
		for(int i = 0; i < N - 1; i++) {
			// 두 절대값이 같지 않을 때 ex) 99, -98 
			// binarySearch 함수는 찾는 값이 없을 때
			// 처음으로 더 큰 원소가 나타나는 지점 or 더 큰 원소가 없는 경우 마지막 인덱스 + 1 리턴
			// 특이하게 -(해당 지점 - 1)를 리턴한다.
			int idx1 = -(Arrays.binarySearch(arr, i + 1, N, -arr[i]) + 1);
			
			// 두 절대값이 같을 때 -> 해당 인덱스를 리턴
			int idx2 = Arrays.binarySearch(arr, i + 1, N, -arr[i]);
			
			// 같은 종류 용액을 섞을 때 -> 정렬했으므로, 붙어있는 두 원소를 더 했을 때 0에 가까움
			// ex) 1, 2 or -2, -1
			if(MN > Math.abs(arr[i] + arr[i + 1])) {
				MN = Math.abs(arr[i] + arr[i + 1]); // 0에 가까운지를 비교해야하므로, 절댓값을 비교해야함
				ans[0] = arr[i]; ans[1] = arr[i + 1]; // 값 대입
			}
			
			// 현재 찾고자 하는 원소의 절댓값이 가장 근접한 원소의 절댓값보다 큰 경우
			// 근접한 원소 인덱스 + 1을 리턴하므로, 1을 뺴줘야 함
			if(idx1 - 1 < N && idx1 - 1 >= 0 && idx1 - 1 != i) {
				if(MN > Math.abs(arr[i] + arr[idx1 - 1])) {
					MN = Math.abs(arr[i] + arr[idx1 - 1]);
					ans[0] = arr[i]; ans[1] = arr[idx1 - 1];
				}
			}
			
			// 현재 찾고자 하는 원소의 절댓값이 가장 근접한 원소의 절댓값보다 작은 경우
			// 근접한 원소 인덱스 리턴
			if(idx1 < N && idx1 >= 0 && idx1 != i) {
				if(MN > Math.abs(arr[i] + arr[idx1])) {
					MN = Math.abs(arr[i] + arr[idx1]);
					ans[0] = arr[i]; ans[1] = arr[idx1];
				}
			}
			
			// 절댓값이 같은 경우
			if(idx2 < N && idx2 >= 0 && idx2 != i) {
				if(MN > Math.abs(arr[i] + arr[idx2])) {
					MN = Math.abs(arr[i] + arr[idx2]);
					ans[0] = arr[i]; ans[1] = arr[idx2];
				}
			}
		}
		
		// 정답 배열 정렬
		Arrays.sort(ans);
		
		for(int answer : ans)
			System.out.print(answer + " ");
	}
	
}
