import java.io.*;
import java.util.*;

public class 디스크트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node root = new Node();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            root.makeTree(input);
        }
        DFS(root, 0);
    }

    private static void DFS(Node root, int L) {
        if(root.child.isEmpty()) return;
        for (String ss : root.child.keySet()) {
            System.out.println(" ".repeat(L) + ss);
            // 자식노드 가져와서 공백하나 추가 후 
            // DFS로 계속해서 출력
            DFS(root.child.get(ss), L + 1);
        }
    }

    static class Node {
        Map<String, Node> child = new TreeMap<>();

        public void makeTree(String input) {
            Node cur = this;
            
            // 역슬래시를 기준으로 split 후
            for (String token : input.split("\\\\")) {
                // 현재 계층이 자식에 없다면
                if (!cur.child.containsKey(token)) cur.child.put(token, new Node());
                
                // 방금 추가한 자식을 cur로 다시 설정하여 
                // 하위 계층을 for문동안 계속 추가해야함
                cur = cur.child.get(token);
            }
        }
    }
}
