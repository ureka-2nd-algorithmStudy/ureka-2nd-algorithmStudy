package pr.solution_가장큰수;
//문제 이해를 잘못해서 틀린 코드
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
public class Solution1 {
    public String solution(int[] numbers) {
        String[] numbers_str = new String[numbers.length];
        
        for(int i = 0; i < numbers.length ; i++){
            numbers_str[i] = String.valueOf(numbers[i]);
        }
        
        ArrayList<Character> char_arr = new ArrayList<>();
        for(String number: numbers_str){            
            if(number.length() == 1){
                char_arr.add(number.charAt(0));
            }else{
                char[] tmp = number.toCharArray();
                for(char c : tmp){
                    char_arr.add(c);
                }
            }
        }
        
        Collections.sort(char_arr, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(char c : char_arr){
            sb.append(c);
        }
        String answer = sb.toString();
        
        return answer;
        
    }
}