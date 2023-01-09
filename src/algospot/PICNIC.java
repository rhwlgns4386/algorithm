package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PICNIC {
    private static boolean[][] friends;
    private static BufferedReader br;

    private static boolean[] visit;
    public static void main(String[] args) throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));;
        int C=Integer.parseInt(br.readLine().trim());

        for(int i=0;i<C;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            System.out.println(solution(n,m));
        }
    }

    private static int solution(int n, int m) throws IOException {
        friends=new boolean[n][n];
        visit=new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i< m; i++){
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());

            friends[start][end]=true;
            friends[end][start]=true;
        }

        return go(n);
    }

    private static int go(int n) {
        int firstFree = nextNumber(n);
        if(firstFree==-1) return 1;
        int count=0;
        for(int i=firstFree+1;i<n;i++){
            if(!visit[i]&&friends[firstFree][i]){
                visit[i]=visit[firstFree]=true;
                count+=go(n);
                visit[i]=visit[firstFree]=false;
            }
        }
        return count;
    }

    private static int nextNumber(int n) {
        for(int j = 0; j< n; j++){
            if(!visit[j]){
                return j;
            }
        }
        return -1;
    }

}
