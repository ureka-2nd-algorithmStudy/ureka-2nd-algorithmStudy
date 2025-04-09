import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node(i);

        // 연결 리스트 구성
        for (int i = 1; i < n; i++) {
            nodes[i - 1].next = nodes[i];
            nodes[i].prev = nodes[i - 1];
        }

        Node cursor = nodes[k];
        Deque<Node> stack = new ArrayDeque<>();

        for (String c : cmd) {
            char command = c.charAt(0);

            if (command == 'U') {
                int x = Integer.parseInt(c.substring(2));
                while (x-- > 0) cursor = cursor.prev;
            } else if (command == 'D') {
                int x = Integer.parseInt(c.substring(2));
                while (x-- > 0) cursor = cursor.next;
            } else if (command == 'C') {
                stack.push(cursor);
                cursor.isDeleted = true;

                if (cursor.prev != null) cursor.prev.next = cursor.next;
                if (cursor.next != null) cursor.next.prev = cursor.prev;

                cursor = (cursor.next != null) ? cursor.next : cursor.prev;
            } else if (command == 'Z') {
                Node restore = stack.pop();
                restore.isDeleted = false;

                if (restore.prev != null) restore.prev.next = restore;
                if (restore.next != null) restore.next.prev = restore;
            }
        }

        // 정답 문자열 구성
        StringBuilder sb = new StringBuilder();
        for (Node node : nodes) {
            sb.append(node.isDeleted ? 'X' : 'O');
        }
        return sb.toString();
    }

    static class Node {
        int index;
        boolean isDeleted;
        Node prev, next;

        Node(int index) {
            this.index = index;
        }
    }
}
