package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1535 {

    private static int N;
    private static int[][] a;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        a = new int[N][2];
        for(int i=0;i<2;i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j = 0; j< N; j++){
                a[j][i]=Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(go(100,0));
    }

    private static int go(int hp,int idx) {
        if(idx==N) return 0;

        int result=0;
        result=Math.max(result,go(hp, idx + 1));
        if(hp-a[idx][0]>0){
            result=Math.max(result,go(hp-a[idx][0],idx+1)+a[idx][1]);
        }

        return result;
    }
}
