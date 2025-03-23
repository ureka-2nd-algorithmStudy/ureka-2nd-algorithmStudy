package boj.p11279_힙_최대힙;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
public class P11279 {
	static PriorityQueue <Integer> queue;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		queue = new PriorityQueue<>((o1,o2) -> Integer.compare(o2, o1));
		 
		int[] input = new int[N]; 
		for(int i = 0; i < N; i ++) {
			input[i] = Integer.parseInt(br.readLine());			
		}
		
		for(int i = 0; i < N; i++) {
			if(input[i] == 0) {
				
				if(queue.peek() != null) {
					System.out.println( queue.poll());
				}else {
					System.out.println("0");	
				}
				
				
			}else {
				queue.offer(input[i]);
			}			
		}
	}
}
