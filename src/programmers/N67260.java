package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class N67260 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
                solution.solution(9, new int[][]{{0, 1}, {0, 3}, {0, 7}, {8, 1}, {3, 6}, {1, 2}, {4, 7}, {7, 5}},
                        new int[][]{{4, 1}, {8, 7}}));
    }

    static class Solution {

        public boolean solution(int n, int[][] path, int[][] order) {
            HashSet<Integer>[] a = new HashSet[n];

            for (int[] vector : path) {
                int start = vector[0];
                int end = vector[1];
                if(a[start]==null){
                    a[start]=new HashSet<>();
                }
                if(a[end]==null){
                    a[end]=new HashSet<>();
                }
                a[start].add(end);
                a[end].add(start);
            }

            List<Integer> leaf = bfs(a, 0);

            for (int[] vector : order) {
                int start = vector[0];
                int end = vector[1];
                a[end].add(start);
            }

            for (Integer node : leaf) {
                int[] visit = new int[n];
                if (!dfs(a, visit, node)) {
                    return false;
                }
            }
            return true;
        }

        //현재 노드는 dfs를 돌고 있지만 완료되지 않았다
        private boolean dfs(HashSet<Integer>[] a, int[] visit, Integer here) {
            visit[here] = 1;

            for (Integer next:a[here]){
                if(visit[next]==1){
                    return false;
                }else if(visit[next]!=2){
                    if(!dfs(a, visit, next)){
                        return false;
                    }
                }
            }
            visit[here]=2;
            return true;
        }

        private List<Integer> bfs(HashSet<Integer>[] a, int startNode) {
            LinkedList<Integer> q = new LinkedList<>();
            q.add(startNode);

            boolean[] visit = new boolean[a.length];
            visit[startNode] = true;

            ArrayList<Integer> leaf = new ArrayList<>();
            while (!q.isEmpty()) {
                Integer here = q.remove();

                boolean isLeaf = true;
                HashSet<Integer> nodes = (HashSet<Integer>) a[here].clone();
                for (Integer next : nodes) {
                    if (!visit[next]) {
                        isLeaf = false;
                        q.add(next);
                        visit[next] = true;
                        a[here].remove(next);
                    }
                }

                if (isLeaf) {
                    leaf.add(here);
                }
            }

            return leaf;
        }
    }

}
