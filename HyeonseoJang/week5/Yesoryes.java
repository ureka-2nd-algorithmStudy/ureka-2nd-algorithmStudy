import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Yesoryes {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Set<Integer> gomgoms = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 1번부터 n번까지 그래프 삽입
        for(int i=0;i<=n;i++) graph.add(new ArrayList<>());

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }
        int s = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<s;i++){
            gomgoms.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(BFS(1));
    }

    private static String BFS(int num){
		    // 시작 정점(1번) 자체에 곰곰이가 있는 경우
        if(gomgoms.contains(num)){ return "Yes";}
        
        Queue<Integer> qu = new ArrayDeque<>();
        qu.add(num);

        // 사이클이 없으므로 체크배열 선언 X
        while(!qu.isEmpty()){
            int cur = qu.poll();
            // 곰곰이를 만나지 않고 막다른길에 도착했으면
            if(graph.get(cur).isEmpty()) return "yes";
						
						// 현재 정점에서 곰곰이를 만나지 않고 갈 수 있는 모든 정점 큐에 삽입
            for(int pos : graph.get(cur)){
                if(!gomgoms.contains(pos)){
                    qu.offer(pos);
                }
            }
        }
        return "Yes";
    }
}