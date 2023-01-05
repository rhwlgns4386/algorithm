package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOARDCOVER {

    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine().trim());

        for(int i=0;i<C;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H=Integer.parseInt(st.nextToken());
            int W=Integer.parseInt(st.nextToken());

            System.out.println(solution(H,W));;
        }
    }

    private static int solution(int h, int w) throws IOException {
        int[][] map = new int[h][w];

        for(int i=0;i<h;i++){
            String[] space = br.readLine().split("");

            for(int j=0;j<w;j++){
                if(space[j].equals("#")){
                    map[i][j]=1;
                }
            }
        }

        return go(map);
    }


    private static int go(int[][] map) {
        int x=-1,y=-1;
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                if(map[i][j]==0){
                    x=i;
                    y=j;
                    break;
                }
            }
            if(x!=-1) break;
        }

        if(x==-1) return 1;

        int result=0;
        for(int i=0;i<4;i++){
            if(set(map,x,y,i,1)){
                result+=go(map);
            }
            set(map, x,y,i,-1);
        }

        return result;
    }

    private static int[][][] coverType={
            {{0,0},{1,0},{0,1}},
            {{0,0},{0,1},{1,1}},
            {{0,0},{1,0},{1,1}},
            {{0,0},{1,0},{1,-1}}};
    private static boolean set(int[][] map, int x, int y, int type, int flag) {
        boolean ok=true;
        for(int i=0;i<3;i++){
            int nx=x+coverType[type][i][0];
            int ny=y+coverType[type][i][1];
            if(0>nx || 0>ny || nx>=map.length || ny>= map[0].length){
                ok=false;
            }else if((map[nx][ny]+=flag)>1){
                ok=false;
            }
        }

        return ok;
    }
}
