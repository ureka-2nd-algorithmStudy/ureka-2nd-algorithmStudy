import java.io.*;
import java.util.*;

public class 완전이진트리 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
     
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(;st.hasMoreTokens();) list.add(Integer.parseInt(st.nextToken()));

				// 주어진 리스트로 트리를 구성한다.
        Node tree = makeTree(list);

        BFS(tree);
        System.out.println(sb);
    }

    private static void BFS(Node root) {
        Queue<Node> qu = new ArrayDeque<>();
        qu.offer(root);

        while(!qu.isEmpty()){
            int size = qu.size();
            for(int i=0;i<size;i++){
                Node cur = qu.poll();
                sb.append(cur.val).append(" ");
                if(cur.lt != null) qu.offer(cur.lt);
                if(cur.rt != null) qu.offer(cur.rt);
            }
            sb.append("\n");
        }
    }

		// 
    private static Node makeTree(List<Integer> list) {
        if(list.isEmpty()) return null;

        int size = list.size();
        int mid = size / 2;
				
				// 리스트의 가운데 값은 노드의 값
        Node root = new Node(list.get(mid));
        
				// 가운데를 제외한 왼쪽리스트, 오른쪽 리스트로 다시 하위 트리를 구성
        root.lt = makeTree(list.subList(0, mid));
        root.rt = makeTree(list.subList(mid + 1, size));
				
				// 구성 완료된 트리를 리턴
        return root;
    }

    static class Node{
        int val;
        Node lt;
        Node rt;
        Node(int val){
            this.val = val;
            lt = null;
            rt = null;
        }
    }
}
