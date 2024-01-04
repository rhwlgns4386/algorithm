package programmers;

import java.util.*;

public class N150364 {
    static class Solution {
        static int[] dp = new int[101];
        static int completeCount;

        static {
            Arrays.fill(dp, 101);
            for (int i = 1; i <= 3; i++) {
                dp[i] = 1;
            }

            for (int i = 4; i < dp.length; i++) {
                for (int j = 1; j <= 3; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j] + 1);
                }
            }
        }

        static int[] targetList;
        static boolean zeroFlag;
        static ArrayList<Integer> treeTraversalNodes;

        public int[] solution(int[][] edges, int[] target) {
            targetList = target;
            completeCount = 0;
            zeroFlag = false;
            treeTraversalNodes=new ArrayList<>();

            HashMap<Integer, Node> nodeMap = new HashMap<>();
            nodeMap.put(1, new Node(1));


            int sum = Arrays.stream(target).sum();
            if (sum == 0) {
                return new int[]{};
            }

            HashSet<Integer> leafNodeNumber = initTreeAndFindLeafNode(edges, nodeMap);
            Node root = nodeMap.get(1);
            if (!isPossible(leafNodeNumber, root)) {
                return new int[]{-1};
            }


            for (Node node : nodeMap.values()) {
                int targetCount = target[node.number - 1];
                int nodeCount = node.count;
                int dist = targetCount - nodeCount;

                int three = dist / 2;
                int two = dist % 2;
                int one = nodeCount - three - two;

                for (int i = 0; i < three; i++) {
                    node.pq.add(3);
                }
                for (int i = 0; i < two; i++) {
                    node.pq.add(2);
                }
                for (int i = 0; i < one; i++) {
                    node.pq.add(1);
                }
            }

            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < treeTraversalNodes.size(); i++) {
                result.add(nodeMap.get(treeTraversalNodes.get(i)).pq.remove());
            }

            return result.stream().mapToInt(i -> i).toArray();
        }

        private static boolean isPossible(HashSet<Integer> leafNodeNumber, Node root) {
            HashSet<Integer> visit = new HashSet<>(leafNodeNumber);
            for (int i = 0; i < 101 * 100; i++) {
                int drop = root.drop();
                if(visit.contains(drop)){
                    visit.remove(drop);
                }
                if (completeCount == leafNodeNumber.size()-getZeroCount(visit)) {
                    return true;
                }
            }
            return false;
        }

        private static int getZeroCount(HashSet<Integer> visit) {
            int count=0;
            for(Integer zero:visit){
                if(targetList[zero-1]==0){
                    count++;
                }
            }
            return count;
        }

        private static HashSet<Integer> initTreeAndFindLeafNode(int[][] edges, HashMap<Integer, Node> nodeMap) {
            for (int[] vertex : edges) {
                int start = vertex[0];
                int end = vertex[1];

                Node startNode = nodeMap.getOrDefault(start, new Node(start));
                Node endNode = nodeMap.getOrDefault(end, new Node(end));

                startNode.addChild(endNode);

                nodeMap.put(start, startNode);
                nodeMap.put(end, endNode);
            }

            HashSet<Integer> leafNodeNumber = new HashSet<>();
            for (Node node : nodeMap.values()) {
                if (node.child.size() == 0) {
                    leafNodeNumber.add(node.number);
                    continue;
                }
                node.sort();
            }
            return leafNodeNumber;
        }

        static class Node {
            private int number;
            private ArrayList<Node> child;

            private Integer chooseIndex = 0;
            private int count = 0;
            private boolean flag = false;

            private PriorityQueue<Integer> pq = new PriorityQueue<>();

            public Node(int number) {
                this.number = number;
                child = new ArrayList<>();
            }

            public int drop() {
                if (child.size() == 0) {
                    count++;
                    treeTraversalNodes.add(number);
                    if (!flag) {
                        if (dp[targetList[number - 1]] <= count && count <= targetList[number - 1]) {
                            flag = true;
                            completeCount++;
                        }
                    } else {
                        if (!(dp[targetList[number - 1]] <= count && count <= targetList[number - 1])) {
                            flag = false;
                            completeCount--;
                        }
                    }
                    return number;
                }

                int drop = child.get(chooseIndex).drop();
                chooseIndex = nextChoose();
                return drop;
            }

            public void addChild(Node childNode) {
                this.child.add(childNode);
            }

            public void sort() {
                child.sort((o1, o2) -> Integer.compare(o1.number, o2.number));
            }

            private Integer nextChoose() {
                return child.size() - 1 == chooseIndex ? 0 : chooseIndex + 1;
            }
        }
    }
}
