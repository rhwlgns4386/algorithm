package programmers;

import java.util.ArrayList;
import java.util.LinkedList;

public class N49189_2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(6,new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }

    static class Solution {
        public int solution(int n, int[][] edge) {
            ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<=n;i++){
                a.add(new ArrayList<>());
            }

            for(int[] e:edge){
                int start = e[0];
                int end = e[1];

                a.get(start).add(end);
                a.get(end).add(start);
            }

            boolean[] visit = new boolean[n + 1];
            return bfs(a,1,visit);
        }

        private static int bfs(ArrayList<ArrayList<Integer>> a, int start, boolean[] visit) {
            visit[start]=true;

            LinkedList<Integer> q = new LinkedList<>();
            q.add(start);

            int size=0;
            while (!q.isEmpty()){
                size=q.size();
                for(int i=0;i<size;i++){
                    Integer node = q.remove();

                    for(Integer next:a.get(node)){
                        if(!visit[next]){
                            visit[next]=true;
                            q.add(next);
                        }
                    }
                }
            }

            return size;
        }
    }
}
