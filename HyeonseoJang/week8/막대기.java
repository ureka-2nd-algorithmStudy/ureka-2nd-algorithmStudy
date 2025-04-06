import java.io.*;

public class 막대기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int answer = solution2(X);
        System.out.println(answer);
    }

    private static int solution1(int x) {
        int cnt = 0;
        for(int i=64;i>0;i>>=1){
            if(x==0) return cnt;

            if(x>=i){
                x-=i;
                cnt++;
            }
        }
        return cnt;
    }

    private static int solution2(int x) {
        int cnt = 0;
        String str = Integer.toBinaryString(x);
        for(char c: str.toCharArray()) if(c=='1') cnt++;
        return cnt;
    }
}
