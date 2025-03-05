package Week_04;

import java.io.*;
import java.util.*;
import java.math.*;

public class BOJ_1931_회의실_배정 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static Time[] timeArr;
    private static int n;

    public static void main(String[] args) throws IOException {
        init();
        bw.write(solution() + "\n");
        close();
    }

    private static int solution() {
        Arrays.sort(timeArr, new Comparator<Time>() {
            @Override
            public int compare(Time t1, Time t2) {
                if (t1.end == t2.end) {
                    return t1.start - t2.start;
                }
                return t1.end - t2.end;
            }
        });

        int count = 1;
        int endTime = timeArr[0].end;

        for (int i = 1; i < timeArr.length; i++) {
            if (timeArr[i].start >= endTime) {
                count++;
                endTime = timeArr[i].end;
            }
        }

        return count;
    }

    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        timeArr = new Time[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            timeArr[i] = new Time(start, end);
        }
    }

    private static void close() throws IOException {
        br.close();

        bw.flush();
        bw.close();
    }
}

class Time {
    int start;
    int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }
}