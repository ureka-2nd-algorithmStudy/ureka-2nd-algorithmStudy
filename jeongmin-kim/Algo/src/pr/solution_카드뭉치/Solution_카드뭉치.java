package pr.solution_카드뭉치;

import java.util.Queue;
import java.util.LinkedList;
public class Solution_카드뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        
        for(String cardsEle : cards1){         
            q1.add(cardsEle);
        }
        for(String cardsEle : cards2){
            q2.add(cardsEle);
        }
        String answer = "";
        for(String word: goal){
            String tmp1 = q1.peek();
            String tmp2 = q2.peek();
            if(word.equals(tmp1)){
                q1.poll();
                answer = "Yes";
            }else if(word.equals(tmp2)){
                q2.poll();
                answer = "Yes";
            }else{
                // System.out.println(word);
                // System.out.println(tmp1);
                // System.out.println(tmp2);
                answer = "No";
                break;
            }
                        
        }
                            
        
        return answer;
    }
}