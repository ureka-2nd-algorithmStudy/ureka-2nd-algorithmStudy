package Week_01;

import java.io.*;
import java.util.*;
import java.math.*;

public class BOJ_1431_시리얼번호 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static String[] numberArr;
    private static int n;

    public static void main(String[] args) throws IOException {
        init();
        String result = solution();
        bw.write(result);
        close();
    }

    private static String solution() {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(numberArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length())
                    return Integer.compare(o1.length(), o2.length());

                int a = sum(o1);
                int b = sum(o2);

                if (a != b)
                    return Integer.compare(a, b);

                return o1.compareTo(o2);
            }
        });

        for (String num : numberArr)
            sb.append(num).append("\n");

        return sb.toString();
    }

    private static int sum(String o) {
        int temp = 0;

        for (char c : o.toCharArray())
            if (Character.isDigit(c))
                temp += c - '0';

        return temp;
    }

    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        numberArr = new String[n];

        for (int i = 0; i < n; i++)
            numberArr[i] = br.readLine();
    }

    private static void close() throws IOException {
        br.close();

        bw.flush();
        bw.close();
    }
}
