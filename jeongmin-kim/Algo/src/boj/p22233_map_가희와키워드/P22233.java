package boj.p22233_map_가희와키워드;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P22233 {
	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);

        // 첫 번째 줄 입력
        int n = scanner.nextInt();  // 5
        int m = scanner.nextInt();  // 2
        scanner.nextLine(); // 개행 문자 소비

        // 나머지 줄 입력
        List<String> inputs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            inputs.add(scanner.nextLine());
        }

        ArrayList<ArrayList<String>> blogKeyword = new ArrayList<>();
        
        List<String> inputs2 = new ArrayList<>();
        inputs2 = new ArrayList<>();
        for(int i = 0; i < m; i++) {
        	inputs2.add(scanner.nextLine());
        }
        
        for(String s: inputs2) {
        	StringTokenizer st = new StringTokenizer(s,",");
        	ArrayList<String> keywords = new ArrayList<>();
        	while(st.hasMoreTokens()) {
        		keywords.add(st.nextToken());
        	}
        	blogKeyword.add(keywords);
        }
        //있는지 찾아보고, 있으면 지우면됨
        for(ArrayList<String> keywords : blogKeyword) {   
        	int contain = 0;
        	for(String keyword: keywords) {
        		if(inputs.contains(keyword)) {
        			contain++;
        			for(int i = 0; i < inputs.size(); i++) {
        				if (inputs.get(i).equals(keyword)) {
        					inputs.remove(i);
        				}
        			}        			
        		}
        	}
        	System.out.println(inputs.size());
        }
	}
}
