import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] arr = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);

        Arrays.sort(arr, (a,b) ->{
            if(a.charAt(0)==b.charAt(0)) return (b+a).compareTo(a+b);
            else return b.charAt(0) - a.charAt(0);
        });
        
        for(String ss: arr) sb.append(ss);
        
        String answer = sb.toString();
        if(answer.replaceAll("0","").isEmpty()) return "0";
        return answer;
    }
}