package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2864 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        String s1 = st.nextToken();
        String s2 = st.nextToken();
        System.out.print((Integer.parseInt(s1.replace("6", "5"))
                + Integer.parseInt(s2.replace("6", "5")))
                +" "+
                (Integer.parseInt(s1.replace("5", "6"))
                + Integer.parseInt(s2.replace("5", "6")))
        );
    }
}
