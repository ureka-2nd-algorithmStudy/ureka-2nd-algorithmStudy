package bitMasking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b_막대기_1094 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
	
	
		int stick = 64;
		int count = 0;
		
		if ( X == 64 ) {
			System.out.println(1);
			return;
		}
	
		while ( stick != 1 ) {
			
				stick = stick >> 1;
				
				if ( stick <= X) {
					X = X - stick;
					count++;
				
				}
			}
			
		System.out.println(count);
		}
		
		
	}


