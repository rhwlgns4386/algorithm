package programmers.kakao2023BlindRecuruitment;

import java.util.LinkedList;

public class N6 {
    static class Pair{
        int x;
        int y;
        int cost;
        String ans;

        public Pair(int x, int y, int cost, String ans) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.ans = ans;
        }
    }

    static int[] dx={1,0,0,-1};
    static int[] dy={0,-1,1,0};
    static char[] dc={'d','l','r','u'};
    public static void main(String[] args) {
        System.out.println(solution(3,4,2,3,3,1,2500));
    }
//    dlru
    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        int[][] map=new int[n][m];

        map[r-1][c-1]=2;
        String go = go(k, 0, map, "", x - 1, y - 1);
        if(go==null){
            go="impossible";
        }
        return go;
    }
    private static String go(int k,int index,int[][] map,String ans,int x,int y){
        if(index>k) return null;
        if(index==k && map[x][y]==2) return ans;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(0<=nx && nx<map.length && 0<=ny && ny<map[0].length){
                String go = go(k, index + 1, map, ans + dc[i], nx, ny);
                if(go!=null){
                    return go;
                }
            }
        }
        return null;
    }

    private static Pair bfs(int r, int c,int[][] map,int k) {
        int n=map.length;
        int m=map[0].length;
        LinkedList<Pair> q = new LinkedList<>();
        q.add(new Pair(r -1, c -1,0,""));
        while (!q.isEmpty()){
            Pair pair = q.remove();
            int x = pair.x;
            int y= pair.y;
            int cost= pair.cost;
            String ans= pair.ans;

            if(cost>k) continue;
            if(map[x][y]==2 && pair.cost==k){
                return pair;
            }

            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(0<=nx && nx<n && 0<=ny && ny<m){
                    switch (i){
                        case 0:
                            q.add(new Pair(nx,ny,cost+1,ans+"d"));
                            break;
                        case 1:
                            q.add(new Pair(nx,ny,cost+1,ans+"l"));
                            break;
                        case 2:
                            q.add(new Pair(nx,ny,cost+1,ans+"r"));
                            break;
                        case 3:
                            q.add(new Pair(nx,ny,cost+1,ans+"u"));
                            break;
                    }
                }
            }
        }
        return null;
    }
}
