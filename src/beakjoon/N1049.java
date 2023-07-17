package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        int packageMin=1001;
        int singleMin=1001;
        for(int i=0;i<m;i++){
            st=new StringTokenizer(in.readLine());
            int packages=Integer.parseInt(st.nextToken());
            int single=Integer.parseInt(st.nextToken());
            packageMin=Math.min(packageMin,packages);
            singleMin=Math.min(singleMin,single);
        }

        int chose=Math.min(packageMin,singleMin*6);
        System.out.println(chose*(n/6)+Math.min((n%6)*singleMin,chose));

    }
}
