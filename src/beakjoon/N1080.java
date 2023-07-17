package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1080 {
    public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        int[][] A=new int[n][m];
        for(int i=0;i<n;i++){
            String s = in.readLine();
            for(int j=0;j<m;j++){
                A[i][j]=Integer.parseInt(Character.toString(s.charAt(j)));
            }
        }

        int[][] B=new int[n][m];
        for(int i=0;i<n;i++){
            String s = in.readLine();
            for(int j=0;j<m;j++){
                B[i][j]=Integer.parseInt(Character.toString(s.charAt(j)));
            }
        }

        int count=0;
        for(int i=0;i<n-2;i++){
            for(int j=0;j<m-2;j++){
                if(A[i][j]!=B[i][j]){
                    change(A,i,j);
                    count++;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               if(A[i][j]!=B[i][j]){
                   System.out.println(-1);
                   return;
               }
            }
        }

        System.out.println(count);
    }

    private static void change(int[][] a, int x, int y) {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                a[x+i][y+j]=1-a[x+i][y+j];
            }
        }
    }
}
