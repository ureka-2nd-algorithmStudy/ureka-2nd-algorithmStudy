package pr.solution_카드뭉치;

import java.util.Queue;
import java.util.ArrayDeque;

public class Solution_카드뭉치2{
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> queue1 = new ArrayDeque<>();
        Queue<String> queue2 = new ArrayDeque<>();
        
        for(String card : cards1){
            queue1.offer(card);
        }
        for(String card : cards2){
            queue2.offer(card);
        }               
        
        for(String word:goal){                                                           
            if(word.equals(queue1.peek()) || word.equals(queue2.peek())){                
                if(word.equals(queue1.peek())){
                    // System.out.println(queue1.peek());
                    queue1.poll();
                    
                }else{
                    // System.out.println(queue2.peek()); 
                    queue2.poll();
                }
            }else{
                return "No";
            }
        }
        
        
        return "Yes";
    }
}