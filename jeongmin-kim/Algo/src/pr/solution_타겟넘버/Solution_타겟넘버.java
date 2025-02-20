package pr.solution_타겟넘버;
import java.util.*;

class Solution {
    static Queue<Node> queue = new ArrayDeque<>();    
    public int solution(int[] numbers, int target) {                
        int ans = bfs(numbers, target);
        return ans;
    }
    
    static class Node{
        int value;        
        int idx;
        int curSum;
        public Node(int value, int idx, int curSum){
            this.value = value;                        
            this.idx = idx;
            this.curSum = curSum;
        }
    }
    
    int bfs(int[] numbers, int target){
        int cnt = 0;
        //Node node1 = new Node(numbers[0],0,0); 수정 부분
        Node node1 = new Node(numbers[0],0,+numbers[0]);
        Node node2 = new Node(numbers[0],0,-numbers[0]);
        queue.offer(node1);
        queue.offer(node2);
        
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.curSum == target && cur.idx == numbers.length-1) cnt++;
            if(cur.idx + 1 >= numbers.length ) continue;
            // int sumP = cur.curSum + cur.value; 수정 부분
            // int sumM = cur.curSum - cur.value; 수정 부분
            int sumP = cur.curSum + numbers[cur.idx+1];
            int sumM = cur.curSum - numbers[cur.idx+1];

            queue.offer(new Node(numbers[cur.idx+1], cur.idx+1, sumP));
            queue.offer(new Node(numbers[cur.idx+1], cur.idx+1, sumM));
            //System.out.println("----------");
            //System.out.println(sumP);
            //System.out.println(sumM);
            //System.out.println("----------");

        }
        
        return cnt;
            
    }
}
