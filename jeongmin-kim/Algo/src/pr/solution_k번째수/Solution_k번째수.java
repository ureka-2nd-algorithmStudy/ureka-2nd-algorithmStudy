package pr.solution_k번째수;

import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int x = 0; x < commands.length; x++){
            int i = 0;
            int j = 0;
            int k = 0;
            for(int y = 0; y < 3; y++){
                i = commands[x][0];
                j = commands[x][1];
                k = commands[x][2];                                
            }
            int[] tmp = new int[j-i+1];
            
            for(int z = 0; z < tmp.length; z++){
                tmp[z] = array[z+i-1];
            }
            
            Arrays.sort(tmp);
            
            answer[x] = tmp[k-1];
        }
        
    
        return answer;
    }
}