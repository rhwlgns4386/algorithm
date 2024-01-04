package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1030 {
    static boolean[][] blackMap;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        int T=Integer.parseInt(stringTokenizer.nextToken());
        n = Integer.parseInt(stringTokenizer.nextToken());
        int K=Integer.parseInt(stringTokenizer.nextToken());
        int R1=Integer.parseInt(stringTokenizer.nextToken());
        int R2=Integer.parseInt(stringTokenizer.nextToken());
        int C1=Integer.parseInt(stringTokenizer.nextToken());
        int C2=Integer.parseInt(stringTokenizer.nextToken());

        blackMap =new boolean[n][n];
        for(int i=0;i<K;i++){
            for(int j=0;j<K;j++){
                blackMap[i+(n -K)/2][j+(n -K)/2]=true;
            }
        }

        int x1=Math.min(R1,R2);
        int x2=Math.max(R1,R2);
        int y1=Math.min(C1,C2);
        int y2=Math.max(C1,C2);

        for(int i=x1;i<=x2;i++){
            for(int j=y1;j<=y2;j++){
                if(go(i,j,T)){
                    System.out.print("1");
                }else{
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    private static boolean go(int x, int y, int t) {
        if(t==0){
            return false;
        }
        if(go(x/n,y/n,t-1)){
            return true;
        }

        return blackMap[x%n][y%n];
    }
}
