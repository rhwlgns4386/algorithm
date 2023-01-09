import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1780 {
    public static int[] cnt=new int[3];
    public static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
        map=new int[n][n];

        for(int i=0;i<n;i++){
            StringTokenizer stringTokenizer = new StringTokenizer(in.readLine(), " ");
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        solution(0,0,n);
        for(int count:cnt){
            System.out.println(count);
        }
    }

    public static void solution(int x,int y,int n){
        if(same(x,y,n)){
            cnt[map[x][y]+1]+=1;
            return;
        }
        else{
            int len=n/3;
            for (int i=0; i<3; i++) {
                for (int j=0; j<3; j++) {
                    solution(x+i*len, y+j*len, len);
                }
            }
        }
    }

    public static boolean same( int x, int y, int n) {
        for (int i=x; i<x+n; i++) {
            for (int j=y; j<y+n; j++) {
                if (map[x][y] != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
