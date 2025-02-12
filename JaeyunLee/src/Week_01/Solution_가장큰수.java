package Week_01;

import java.util.*;

public class Solution_가장큰수 {
    public String solution(int[] numbers) {
        return simulation(numbers);
    }

    private String simulation(int[] numbers) {
        String[] calc = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++)
            calc[i] = String.valueOf(numbers[i]);

        Arrays.sort(calc, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        StringBuilder sb = new StringBuilder();

        for (String s : calc)
            sb.append(s);

        if (calc[0].equals("0"))
            return "0";

        return sb.toString();
    }
}
