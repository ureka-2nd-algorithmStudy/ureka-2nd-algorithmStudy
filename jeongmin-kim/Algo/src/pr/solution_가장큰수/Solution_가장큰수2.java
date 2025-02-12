package pr.solution_가장큰수;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public String solution(int[] numbers) {
        String[] numbers_str = new String[numbers.length];
        
        for(int i = 0; i < numbers.length ; i++){
            numbers_str[i] = String.valueOf(numbers[i]);
        }
                        
        //array -> Arrays.sort(), ArrayList -> Collections.sort()
        Arrays.sort(numbers_str, (o1,o2)->(o2+o1).compareTo(o1+o2));        
        StringBuilder sb = new StringBuilder();        
        
        for(String number:numbers_str){
            sb.append(number);
        }
        String answer = sb.toString();
        
        return answer;
        
    }
}