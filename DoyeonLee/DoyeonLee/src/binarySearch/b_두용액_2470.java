package binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_두용액_2470 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr); // 정렬
		
		int left = 0;
		int right = N - 1;
		int sumz = Integer.MAX_VALUE; // 0과 제일 차이가 적은 합 저장
		int num1 = 0; //더할 숫자 1
		int num2 = 0; // 더할 숫자 2
		
		while(left < right) {
			int sum = arr[left] + arr[right]; // 두 수를 합
			int absSum = Math.abs(sum);
			
			if ( absSum < sumz) {
				sumz = absSum; // 현재 보다 0에 더 까우면 저장
				num1 = arr[left];
				num2 = arr[right];
			}
			
			if (sum < 0) {
				left++; // 합이 0보다 작으면 오른쪽으로
			} else {
				right--; // 합이 0 보다 크면 왼쪽으로 
			}
		}
		
		System.out.println(num1 + " " + num2);
		
	}
}
