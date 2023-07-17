package programmers;

import java.util.LinkedList;

public class N87694 {
    private static class Solution {
        private static final int[] dx = new int[]{0, 0, 1, -1};
        private static final int[] dy = new int[]{1, -1, 0, 0};

        private static final int MAX = 50;

        private static int[][] map;
        private static int[][] visited;
        private static int answer = 0;

        public static int solution(int[][] rectangle,
                                   int characterX, int characterY,
                                   int itemX, int itemY) {
            map = new int[MAX*2+ 2][MAX*2 + 2];
            visited = new int[MAX*2 + 1][MAX*2+ 1];


            for (int[] rec : rectangle) {
                int x1 = rec[0];
                int y1 = rec[1];
                int x2 = rec[2];
                int y2 = rec[3];

                for(int i=y1*2;i<y2*2+1;i++){
                    for(int j=x1*2;j<x2*2+1;j++){
                        map[i][j]=1;
                    }
                }
            }


            for (int[] rec : rectangle) {
                int x1 = rec[0];
                int y1 = rec[1];
                int x2 = rec[2];
                int y2 = rec[3];

                for(int i=y1*2+1;i<y2*2;i++){
                    for(int j=x1*2+1;j<x2*2;j++){
                        map[i][j]=0;
                    }
                }
            }

            int bfs = bfs(characterY * 2, characterX * 2, itemY * 2, itemX * 2);

            return bfs/2;
        }


        private static int bfs(int x1, int y1, int x2, int y2) {
            LinkedList<int[]> q = new LinkedList<>();
            q.add(new int[]{x1,y1});
            visited[x1][y1]=1;

            while (!q.isEmpty()){
                int[] node = q.remove();
                int x=node[0];
                int y=node[1];

                if(x==x2 && y2==y){
                    return visited[x][y]-1;
                }

                for(int i=0;i<4;i++){
                    int nx=x+dx[i];
                    int ny=y+dy[i];
                    if(inRange(nx,ny) && map[nx][ny]==1 && visited[nx][ny]==0){
                        visited[nx][ny]=visited[x][y]+1;
                        q.add(new int[]{nx,ny});
                    }
                }
            }

            return answer;
        }

        private static boolean inRange(int x, int y) {
            return (x >= 0 && y >= 0 && x < MAX*2 + 1 && y < MAX*2 + 1);
        }
    }

    public static void main(String[] args) {
        int[][] rectangle = new int[][]{
                {1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}
        };
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;


        System.out.println(Solution.solution(rectangle, characterX, characterY, itemX, itemY));
    }
}