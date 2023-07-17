package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2116 {
    static int[][] a;
    static int[] idx={5,3,4,1,2,0};
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        a=new int[N][6];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j=0;j<6;j++){
                a[i][j]=Integer.parseInt(st.nextToken());
            }

        }

        int result=0;
        for(int i=0;i<6;i++){
            int select=a[0][idx[i]];
            int sum=findMax(0,i);

            for(int j=1;j<N;j++){
                for(int k=0;k<6;k++){
                    if(select==a[j][k]){
                        select=a[j][idx[k]];
                        sum+=findMax(j,k);
                        break;
                    }
                }
            }

            result=Math.max(result,sum);
        }

        System.out.println(result);
    }

    private static int findMax(int i,int select) {
        boolean[] check = new boolean[6];
        check[select]=true;
        check[idx[select]]=true;

        int max=0;
        for(int k=0;k<6;k++){
            if(!check[k])max=Math.max(max,a[i][k]);
        }

        return max;
    }

}
