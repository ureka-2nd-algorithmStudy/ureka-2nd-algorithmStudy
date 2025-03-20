import java.io.*;
import java.util.*;

class Main{
    static Set<String> set = new TreeSet<>((a,b) -> {
        if(a.length() != b.length()) return a.length() -b.length();
        else return a.compareTo(b);
    });

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            String str = br.readLine();
            char[] arr = str.toCharArray();
            boolean[] visited = new boolean[arr.length];
            permutation(arr, "", visited);
        }

        set.stream().forEach(System.out::println);
    }

    private static void permutation(char[] arr, String str, boolean[] visited){
        if(str.length() == arr.length){
            set.add(str);
            return;
        }

        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i] = true;
                permutation(arr, str+arr[i], visited);
                visited[i] = false;
            }
        }
    }
}