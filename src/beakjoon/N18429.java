package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N18429 {
    static int[] kit;
    static boolean[] check;
    private static int n,k;

    private static int weight=500;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st=new StringTokenizer(in.readLine());
        kit = new int[n];
        check = new boolean[n];
        for(int i = 0; i< n; i++){
           kit[i]=Integer.parseInt(st.nextToken());
        }

        System.out.println(go(0));
    }

    private static int go(int idx) {
        if(idx==n) return 1;

        int count=0;
        for(int i=0;i<n;i++){
            if(!check[i] && weight-k+kit[i]>=500){
                check[i]=true;
                weight=weight-k+kit[i];
                count+=go(idx+1);
                check[i]=false;
                weight=weight+k-kit[i];
            }
        }

        return count;
    }
}
