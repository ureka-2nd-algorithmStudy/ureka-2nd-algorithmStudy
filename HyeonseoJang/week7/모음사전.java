import java.util.*;

class Solution {
    private final static String[] mo = {"A", "E", "I", "O", "U"};
    // 찾으면 바로 DFS를 끝내기 위한 flag
    static boolean flag = false;
    static int cnt = 0;
    
    public int solution(String word) {
        DFS("", word);
        return cnt;
    }
    
    private static void DFS(String str, String word){
        if(str.equals(word)) flag = true;
                             
        if(str.length()==5) return;
        else{
            for(int i=0;i<mo.length;i++){
                if(flag) return;
                cnt++;
                DFS(str+mo[i], word);
            }
        }
    }
    
}