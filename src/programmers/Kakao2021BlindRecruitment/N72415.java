package programmers.Kakao2021BlindRecruitment;

import java.util.LinkedList;

public class N72415 {

    static class Pair {
        int x;
        int y;
        int cost;

        public Pair(int x, int y,int cost) {
            this.x = x;
            this.y = y;
            this.cost=cost;
        }
    }

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int max=0;

//    public static void main(String[] args) {
//        System.out.println(solution(new int[][]{{1, 0, 0, 3}, {2, 0, 0, 0}, {0, 0, 0, 2}, {3, 0, 1, 0}}, 1, 0));
//    }

//    public static int solution(int[][] board, int r, int c) {
//        int answer = 0;
//        max=0;
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                max=Math.max(board[i][j],max);
//            }
//        }
//
//        boolean[] visit=new boolean[7];
//        return go(r,c,visit,board);
//    }

//    private static int go(int r, int c, boolean[] visit, int[][] board) {
//        int ans=Integer.MAX_VALUE;
//        for (int i=1;i<=max;i++){
//            if(!visit[i]){
//                int[][] group = new int[4][4];
//                for()
//                int dist=bfs(r,c,i,group,board);
//            }
//        }
//        return ans;
//    }
//
//    private static int bfs(int r, int c, int node, int[][] group,int[][] board) {
//        LinkedList<Pair> q = new LinkedList<>();
//        q.add(new Pair(r,c,0));
//        while (!q.isEmpty()){
//            Pair pair = q.remove();
//            int x=pair.x;
//            int y=pair.y;
//            int cost=pair.cost;
//
//            if(board[x][y]==node){
//                group[x][y]=2;
//            }else{
//                group[x][y]=1;
//            }
//
//            for(int i=0;i<4;i++){
//                int nx=x+dx[i];
//                int ny=y+dy[i];
//
//                if(0<=nx && nx<4 && 0<=ny && ny<4){
//                    q.add(new Pair(nx,ny,cost+1));
//                }
//                while(0<=nx && nx<4 && 0<=ny && ny<4){
//
//                }
//            }
//
//        }
//    }
}
