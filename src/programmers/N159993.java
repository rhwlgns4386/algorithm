package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class N159993 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}));
    }

    static class Solution {
        public int solution(String[] maps) {
            Pair start = findCoordinate(maps,'S');
            Pair lever = findCoordinate(maps,'L');
            int leverDist=bfs(maps,start,lever);
            if(leverDist==-1) return -1;

            Pair exit = findCoordinate(maps, 'E');
            int exitDist=bfs(maps,lever,exit);
            if(exitDist==-1) return -1;

            return exitDist+leverDist;
        }

        static int[] dx={0,0,-1,1};
        static int[] dy={-1,1,0,0};
        private int bfs(String[] maps,Pair start, Pair target) {
            boolean[][] visit = new boolean[maps.length][maps[0].length()];
            visit[start.x][start.y]=true;

            Queue<Pair> q = new LinkedList<>();
            q.add(start);

            int dist=0;
            while (!q.isEmpty()){
                int size = q.size();
                for(int s=0;s<size;s++){
                    Pair here = q.remove();
                    if(here.x==target.x && here.y==target.y){
                        return dist;
                    }

                    for(int i=0;i<4;i++){
                        int nx= here.x+dx[i];
                        int ny= here.y+dy[i];
                        if(inRange(maps,nx,ny) && isNotVisit(visit,nx,ny) && isPath(maps,nx,ny)){
                            visit[nx][ny]=true;
                            q.add(new Pair(nx,ny));
                        }
                    }

                }
                dist++;
            }
            return -1;
        }

        private boolean isPath(String[] maps, int x, int y) {
            return !(maps[x].charAt(y)=='X');
        }

        private boolean isNotVisit(boolean[][] visit, int x, int y) {
            return !visit[x][y];
        }

        private boolean inRange(String[] maps,int x, int y) {
            return 0<=x && x<maps.length && 0<=y && y<maps[0].length();
        }

        private Pair findCoordinate(String[] maps, char target) {
            for(int x=0;x<maps.length;x++){
                String line = maps[x];
                for (int y=0;y<maps[0].length();y++){
                    if(line.charAt(y)==target){
                        return new Pair(x,y);
                    }
                }
            }
            return new Pair(-1,-1);
        }

        static class Pair{
            int x;
            int y;

            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
