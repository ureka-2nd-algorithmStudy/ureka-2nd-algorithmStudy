package boj.p16165;

import java.io.*;
import java.util.*;

public class P16165_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
                       
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        //group 을 입력 받았을 때 member를 출력
        HashMap<String, ArrayList<String>> groupToMembers = new HashMap<>();
        //member를 입력 받았을 때 group을 출력
        HashMap<String, String> memberToGroup = new HashMap<>();

        
        
        
       
        for (int i = 0; i < N; i++) {
            String groupName = br.readLine();
            int memberCnt = Integer.parseInt(br.readLine());
            ArrayList<String> members = new ArrayList<>();
            
            for (int j = 0; j < memberCnt; j++) {
                String memberName = br.readLine();
                members.add(memberName);
                memberToGroup.put(memberName, groupName);
            }
            
            //member들을 group key로 넣기
            Collections.sort(members);
            groupToMembers.put(groupName, members);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            int problemKind = Integer.parseInt(br.readLine());

            if (problemKind == 0) {
                for (String member : groupToMembers.get(name)) {
                    sb.append(member).append("\n");
                }
            } else {
                sb.append(memberToGroup.get(name)).append("\n");
            }
        }
        
        System.out.print(sb);
    }
}
