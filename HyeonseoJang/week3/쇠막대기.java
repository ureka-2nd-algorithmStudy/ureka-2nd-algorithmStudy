import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class 쇠막대기{
    public int solution(String str){
        Deque<Character> st = new ArrayDeque<>();
        int answer=0;
        char[] arr = str.toCharArray();
        for(int i=0;i<arr.length;i++){
		        // 여는 괄호면 쇠막대기의 시작이므로 push
            if(arr[i]=='(') st.push(arr[i]);
            else{
		            // 쇠막대기의 일부든 레이저든 ) 가 나오면 스택에서 하나를 제거해야 함.
                st.pop();
                // 직전 문자가 닫는 괄호면 레이저이므로 스택의 크기만큼 증가
                if(arr[i-1]=='('){
                    answer+= st.size();
                // 아니면 쇠막대기의 끝이므로 하나 증가
                }else answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        String str = br.readLine();
        System.out.println(T.solution(str));
    }
}