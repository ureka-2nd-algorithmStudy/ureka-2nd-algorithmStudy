package p1094_bitmasking_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1094 {
	
	static int idxShortest = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		
		List<Integer> sticks = new ArrayList<>();
		sticks.add(64);
		while(sum(sticks) < X) {
			//가지고 있는 막대중 길이가 가장 짧은 것 -> 절반으로 자르기 
			int shortest = getShortest(sticks);
			if((sum(sticks)-shortest/2) >= X) {
				sticks = processSticks(sticks);
//				System.out.println(sticks.size());
			}
			System.out.println(shortest);
		}
		
		System.out.println(sticks.size());
	}
	
	static int getShortest(List<Integer> sticks) {
		int min = sticks.get(0);
		for(int i = 0; i < sticks.size(); i++) {
			if (sticks.get(i) < min) {
				min = sticks.get(i);
				idxShortest = i;
			}
		}
		
		return min;
		
	}
	static List<Integer> processSticks(List<Integer> sticks){
		List<Integer> tmp = new ArrayList<Integer>();
		
		for(int i = 0 ;i < sticks.size() ; i++) {
			if(i == idxShortest) continue;
			tmp.add(sticks.get(i));
		}
		
		return tmp;
	}
	static int sum(List<Integer> sticks) {
		int sum = 0;
		
		for(int i = 0 ; i < sticks.size(); i++) {
			sum += sticks.get(i);
		}
//		System.out.println(sum);
		return sum;
	}
}
