package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        ArrayList<Integer> a = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            String s = st.nextToken();
            a.add(Integer.parseInt(s));
        }

        a.sort((i, j) -> Integer.compare(Math.abs(i), Math.abs(j)));

        int chose1 = 0;
        int chose2 = 0;
        int sum = Integer.MAX_VALUE;
        for (int i = 1; i < a.size(); i++) {
            int here=a.get(i);
            if (Math.abs(a.get(i-1) + here) <= sum) {
                chose1 = a.get(i-1);
                chose2 = here;
                sum = Math.abs(a.get(i-1) + here);
            }
            if (a.size()-1!=i && Math.abs(here + a.get(i+1)) <= sum) {
                chose1 = here;
                chose2 = a.get(i+1);
                sum = Math.abs(here + a.get(i+1));
            }
        }

        System.out.print(Math.min(chose1, chose2) + " ");
        System.out.print(Math.max(chose1, chose2));
    }
}
