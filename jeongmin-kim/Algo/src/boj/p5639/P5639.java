package boj.p5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P5639 {
    static ArrayList<Integer> tree = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        ArrayList<Integer> preOrder = new ArrayList<>();

        while ((input = br.readLine()) != null && !input.isEmpty()) {
            preOrder.add(Integer.parseInt(input));
        }

        // 후위 순회 실행
        traverseDfs(preOrder);
    }

    static void traverseDfs(ArrayList<Integer> order) {
        if (order.isEmpty()) return; // 빈 리스트인 경우 종료

        int root = order.get(0); // 전위 순회 -> 첫째 값이 root
        int boundary = order.size(); // 기본적으로 오른쪽 서브트리 시작 인덱스를 마지막으로 설정

        // 처음으로 root보다 큰 값을 찾으면 그 인덱스를 boundary로 설정
        for (int i = 1; i < order.size(); i++) {
            if (order.get(i) > root) {
                boundary = i;
                break;
            }
        }
        
        //-> left가 더이상 없을 경우, boundary는 1
        //-> right가 더이상 없을 경우, boundary는 order.size()
        
        
        // 자기 보다 작은게 있을 경우, 즉 boundary가 1이 아님 -> 왼쪽 서브트리 탐색 
        if (boundary > 1) traverseDfs(new ArrayList<>(order.subList(1, boundary)));
        // 자기보다 작은게 있을 경우,즉 boundary가 order.size()가 아님 -> 오른쪽 서브트리 탐색
        if (boundary < order.size()) traverseDfs(new ArrayList<>(order.subList(boundary, order.size())));

        // 루트 노드 출력 (후위 순회) (틀림)
        System.out.println(root);
    }
}
