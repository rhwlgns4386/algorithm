package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class N42892 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.solution(new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}}));
        print(solution.solution(new int[][]{{5, 3}}));
    }

    private static void print(int[][] solution1) {
        for (int[] a : solution1) {
            System.out.println(Arrays.toString(a));
        }
    }

    static class Solution {

        public int[][] solution(int[][] nodeinfo) {
            int[][] answer = {};

            HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
            for (int i = 0; i < nodeinfo.length; i++) {
                int x = nodeinfo[i][0];
                int y = nodeinfo[i][1];

                ArrayList<int[]> a = map.getOrDefault(y, new ArrayList<>());
                a.add(new int[]{x, i + 1});
                map.put(y, a);
            }

            Tree tree = new Tree(map);
            answer = new int[2][nodeinfo.length];
            answer[0] = tree.preorderTraversal();
            answer[1] = tree.postorderTraversal();
            return answer;
        }

        static class Tree {
            private HashMap<Integer, Node> graph;
            private int root;

            public Tree(HashMap<Integer, ArrayList<int[]>> map) {
                graph = new HashMap<>();

                List<ArrayList<int[]>> collect = map.entrySet().stream()
                        .sorted((e2, e1) ->
                                Integer.compare(e1.getKey(), e2.getKey()))
                        .map((e) -> e.getValue()).collect(Collectors.toList());

                for (int i = 0; i < collect.size(); i++) {
                    ArrayList<int[]> childs = collect.get(i);
                    childs.sort((a1, a2) -> Integer.compare(a1[0], a2[0]));
                }

                build(collect, 0, 100000, 0);

                this.root = collect.get(0).get(0)[1];
            }

            private int build(List<ArrayList<int[]>> collect, int L, int R, int depth) {
                if (depth == collect.size()) return -1;
                if (L > R) return -1;

                ArrayList<int[]> nodes = collect.get(depth);
                for (int[] node : nodes) {
                    if (L <= node[0] && node[0] <= R) {
                        int left = build(collect, L, node[0] - 1, depth + 1);
                        int right = build(collect, node[0] + 1, R, depth + 1);
                        graph.put(node[1], new Node(left, right));
                        return node[1];
                    }
                }

                return -1;
            }

            public int[] preorderTraversal() {
                ArrayList<Integer> arr = new ArrayList<Integer>();
                preorderTraversal(root, arr);
                return arr.stream().mapToInt(Integer::intValue).toArray();
            }

            public int[] postorderTraversal() {
                ArrayList<Integer> arr = new ArrayList<Integer>();
                postorderTraversal(root, arr);
                return arr.stream().mapToInt(Integer::intValue).toArray();
            }

            private void preorderTraversal(int key, List<Integer> arr) {
                if (key == -1) return;
                Node node = graph.get(key);
                arr.add(key);
                preorderTraversal(node.getLeft(), arr);
                preorderTraversal(node.getRight(), arr);
            }

            private void postorderTraversal(int key, List<Integer> arr) {
                if (key == -1) return;
                Node node = graph.get(key);
                postorderTraversal(node.getLeft(), arr);
                postorderTraversal(node.getRight(), arr);
                arr.add(key);
            }
        }

        static class Node {
            private int left;

            private int right;

            public Node(int left, int right) {
                this.left = left;
                this.right = right;
            }

            public int getLeft() {
                return left;
            }

            public int getRight() {
                return right;
            }
        }
    }
}
