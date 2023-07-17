package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());

        StringTokenizer st = new StringTokenizer(in.readLine());
        long[] dist=new long[n-1];
        for(int i=0;i<n-1;i++){
            dist[i]=Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(in.readLine());
        long[] price=new long[n];
        for(int i=0;i<n;i++){
            price[i]=Long.parseLong(st.nextToken());
        }

        long min=1000000000;
        long pay=0;
        for(int i=0;i<n-1;i++){
            min=Math.min(price[i],min);
            pay+=min*dist[i];
        }

        System.out.println(pay);
    }
}
