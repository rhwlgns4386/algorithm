package programmers;

import java.util.*;

public class N62050 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}}, 3));
        System.out.println(solution.solution(new int[][]{{1, 2, 3, 4}, {8, 7, 6, 5}, {9, 10, 11, 12}, {16, 15, 14, 13}}, 1));
        System.out.println(solution.solution(new int[][]{{10, 11, 10, 11}, {2, 21, 20, 10}, {1, 20, 21, 11}, {2, 1, 2, 1}}, 1));
        System.out.println(solution.solution(new int[][]{{1, 10, 1, 10}, {15, 20, 15, 20}}, 1));
    }


    static class Solution {

        static int MAX = 300 * 300 + 1;
        static int[] dx = {0, 1, 0, -1};
        static int[] dy = {1, 0, -1, 0};
        static int[][] land;
        static int[][] group;
        static int[] visit;
        static int[] rank;

        public int solution(int[][] land, int height) {
            this.land = land;
            group = new int[land.length][land[0].length];

            for (int i = 0; i < group.length; i++) {
                for (int j = 0; j < group[0].length; j++) {
                    group[i][j] = MAX;
                }
            }

            int groupCount = 0;
            for (int i = 0; i < group.length; i++) {
                for (int j = 0; j < group[0].length; j++) {
                    if (group[i][j] == MAX) {
                        grouping(groupCount, height, i, j);
                        groupCount++;
                    }
                }
            }

            PriorityQueue<Ladder> pq = new PriorityQueue<>();
            for (int i = 0; i < land.length; i++) {
                for (int j = 0; j < land[0].length; j++) {
                    for (int k = 0; k < 2; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (inRange(nx, ny) && group[i][j] != group[nx][ny]) {
                            int start = Math.min(group[i][j], group[nx][ny]);
                            int end = Math.max(group[i][j], group[nx][ny]);
                            pq.add(new Ladder(start,end,
                                    Math.abs(land[i][j] - land[nx][ny])));
                        }
                    }
                }
            }


            visit=new int[groupCount];
            rank=new int[groupCount];
            for(int i=0;i<visit.length;i++){
                visit[i]=i;
            }

            int result = 0;
            while (!pq.isEmpty()) {
                Ladder here = pq.remove();
                if (!isUnion(here.start,here.end)) {
                    result += here.weight;
                    union(here.start,here.end);
                }
            }

            return result;
        }

        private void union(int value1, int value2) {
            if(isUnion(value1,value2)) return;
            int union1= find(value1);
            int union2= find(value2);

            if(rank[union1]>=rank[union2]){
                visit[union2]=union1;
                if(rank[union1]==rank[union2])rank[union1]++;
            }else{
                visit[union1]=union2;
            }
        }

        private boolean isUnion(int value1,int value2){
            return find(value1).equals(find(value2));
        }

        private Integer find(int value) {
            return visit[value]==value?value:find(visit[value]);
        }

        private void grouping(int groupCount, int height, int x, int y) {
            group[x][y] = groupCount;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (inRange(nx, ny) && group[nx][ny] == MAX && Math.abs(land[x][y] - land[nx][ny]) <= height) {
                    grouping(groupCount, height, nx, ny);
                }
            }
        }

        private boolean inRange(int x, int y) {
            return 0 <= x && x < land.length && 0 <= y && y < land[0].length;
        }

        static class Ladder implements Comparable<Ladder> {

            int start;
            int end;
            int weight;

            public Ladder(int start,int end, int weight) {
                this.start=start;
                this.end=end;
                this.weight = weight;
            }

            @Override
            public int compareTo(Ladder o) {
                return weight - o.weight;
            }
        }
    }
}
