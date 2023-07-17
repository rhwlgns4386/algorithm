package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N13460_2 {

    static int n,m;
    private static int[][] map;
    private static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken()); m=Integer.parseInt(st.nextToken());
        map = new int[n][m];

        int red=0;
        int blue=0;
        target = 0;
        for(int i=0;i<n;i++){
            String s = in.readLine();
            for(int j=0;j<m;j++){
                if(s.charAt(j)=='#'){
                    map[i][j]=1;
                }else if(s.charAt(j)=='O'){
                    target = calcIndex(i, j);
                }else if(s.charAt(j)=='R'){
                    red= calcIndex(i, j);
                }else if(s.charAt(j)=='B'){
                    blue= calcIndex(i, j);
                }
            }
        }

        if(target==blue){
            System.out.println(-1);
            return;
        }
        System.out.println(bfs(red,blue));
    }

    static int[] dx={1,-1,0,0};

    static int[] dy={0,0,1,-1};
    private static int bfs(int red, int blue) {
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{red,blue});

        boolean[][] visit = new boolean[n * m][n * m];
        visit[red][blue]=true;

        int count=-1;
        while (count++<10){
            int size = q.size();
            while (size-->0){
                int[] node = q.remove();
                int redx=node[0]/m;
                int redy=node[0]%m;
                int bluex=node[1]/m;
                int bluey=node[1]%m;

                if(isInTarget(node[0])){
                    return count;
                }

                for(int i=0;i<4;i++){
                    int moveRed = move(redx, redy, bluex, bluey, i);
                    int moveBlue=0;
                    if(isInTarget(moveRed))moveBlue=move(bluex,bluey,-1,-1,i);
                    else{
                        moveBlue=move(bluex,bluey,moveRed/m,moveRed%m,i);
                        moveRed= move(moveRed/m, moveRed%m, moveBlue/m, moveBlue%m, i);
                    }

                    if(!visit[moveRed][moveBlue] && !isInTarget(moveBlue)){
                        visit[moveRed][moveBlue]=true;
                        q.add(new int[]{moveRed,moveBlue});
                    }
                }
            }
        }
        return -1;
    }

    private static int move(int movex, int movey, int obstaclex, int obstacley, int i) {
        while (true){
            if(!isRange(movex,movey) || (movex==obstaclex && movey==obstacley) || map[movex][movey]==1){
                return calcIndex(movex-dx[i],movey-dy[i]);
            }else if(isInTarget(calcIndex(movex,movey))){
                return calcIndex(movex,movey);
            }
            movex+=dx[i];
            movey+=dy[i];
        }
    }

    private static boolean isRange(int x, int y) {
        return 0<=x && x<n && 0<=y && y<m;
    }

    private static boolean isInTarget(int object) {
        return object==target;
    }

    private static int calcIndex(int i, int j) {
        return (i * m) + j;
    }

}
