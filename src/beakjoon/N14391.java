package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N14391 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine(), " ");
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int[][] map=new int[n][m];

        for(int i=0;i<n;i++){
            char[] inputNumChar = in.readLine().toCharArray();
            for(int j=0;j<m;j++){
                map[i][j]=Character.getNumericValue(inputNumChar[j]);
            }
        }

        int ans=0;
        for(int s=0;s<(1<<n*m);s++){
            int sum=0;
            for(int i=0;i<n;i++){
                int cur=0;
                for(int j=0;j<m;j++){
                    int k=i*m+j;
                    if((s&1<<k)==0){
                        cur=cur*10+map[i][j];
                    }
                    else {
                        sum+=cur;
                        cur=0;
                    }
                }
                sum+=cur;
            }

            for(int j=0;j<m;j++){
                int cur=0;
                for(int i=0;i<n;i++){
                    int k=i*m+j;
                    if((s&1<<k)!=0){
                        cur=cur*10+map[i][j];
                    }
                    else {
                        sum+=cur;
                        cur=0;
                    }
                }
                sum+=cur;
            }

            ans=Math.max(ans,sum);
        }
        System.out.println(ans);
    }
}
