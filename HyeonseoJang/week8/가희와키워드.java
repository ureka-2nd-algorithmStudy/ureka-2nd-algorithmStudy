public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
				
				// set에 키워드 다 추가
        Set<String> set = new HashSet<>();
        for(int i=0;i<n;i++) set.add(br.readLine());
				
				// 정답 기록용 StringBuilder
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<m;i++){
            String[] arr = br.readLine().split(",");
            for(String str : arr){
		            // 키워드가 있다면 제거
                if(set.contains(str)) set.remove(str);
            }
            sb.append(set.size()).append("\n");
        }
        
        System.out.println(sb);
    }
}
