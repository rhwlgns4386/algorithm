package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N20327 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine(), " ");
        int n=Integer.parseInt(stringTokenizer.nextToken());
        int r=Integer.parseInt(stringTokenizer.nextToken());

        int[][] a=new int[(1<<n)][(1<<n)];

        for(int i=0;i<(1<<n);i++){
            stringTokenizer=new StringTokenizer(in.readLine()," ");
            for(int j=0;j<(1<<n);j++){
                a[i][j]=Integer.parseInt(stringTokenizer.nextToken());
            }
        }



        System.out.println();
        for(int i=0;i<(1<<n);i++){
            for(int j=0;j<(1<<n);j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static int[][] operation1(int[][] a,int x,int y,int l,int n){
        int[][] b=new int[(1<<n)][(1<<n)];
        int subSize=(1<<l);
        for(int k=0; k<(1<<n);k+=subSize){
           for(int i=0;i<subSize;i++){
               for(int j=0;j<(1<<n);j++){
                   b[k+i][j]=a[k+subSize-i-1][j];
               }
           }
        }
        return b;
    }


    public static int[][] operation2(int[][] a,int x,int y,int l,int n){
        int[][] b=new int[(1<<n)][(1<<n)];
        int subSize=(1<<l);
        for(int k=0; k<(1<<n);k+=subSize){
            for(int j=0;j<subSize;j++){
                for(int i=0;i<(1<<n);i++){
                    b[i][k+j]=a[i][k+subSize-j-1];
                }
            }
        }
        return b;
    }

    public static int[][] operation3(int[][] a,int x,int y,int l,int n){
        int[][] b=new int[(1<<n)][(1<<n)];

        return b;
    }
}
