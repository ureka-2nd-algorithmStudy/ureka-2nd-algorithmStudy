import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class 오큰수 {
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        answer = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;st.hasMoreTokens();i++) arr[i] = Integer.parseInt(st.nextToken());

        solution(n,arr);

        StringBuilder sb = new StringBuilder();
        for(int a:answer) sb.append(a).append(" ");
        System.out.println(sb);
    }

    private static void solution(int n, int[] arr){
        Deque<Integer> st = new ArrayDeque<>();
        Arrays.fill(answer, -1);

        for(int i=0;i<n;i++){
            // 현재 수보다 스택 top 에 있는 수가 더 작으면
            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
                // 스택의 top 값을 pop하고, 그 위치의 오큰수를 현재 원소로 설정
                answer[st.pop()] = arr[i];
            }
            // 현재 인덱스를 스택에 추가 (오큰수를 아직 찾지 못한 index)
            st.push(i);
        }
    }
}
