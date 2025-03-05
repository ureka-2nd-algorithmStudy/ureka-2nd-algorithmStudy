import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 회의실배정 {
    static PriorityQueue<Conference> pQ = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pQ.add(new Conference(s, e));
        }

        System.out.println(solution());
    }

    private static int solution() {
        int cnt = 0;
        int curEndTime = 0;
        while(!pQ.isEmpty()){
            Conference c = pQ.poll();
            
            // 지금회의 시작시간이 전 회의 끝나는 시간보다 많거나 같으면 
            // 회의 배치
            if(c.startTime >= curEndTime){
                curEndTime = c.endTime;
                cnt++;
            }
        }
        return cnt;
    }

    static class Conference implements Comparable<Conference>{
        int startTime, endTime;
        Conference(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Conference o){
            if(this.endTime != o.endTime) return this.endTime - o.endTime;
           
            // 시작 시간과 끝나는 시간이 같을경우가 있기 때문에 
            // startTime도 빨리 시작하는 경우가 먼저 와야함
            else return this.startTime - o.startTime; 
        }
    }
    
}
