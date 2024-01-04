package programmers.kakao2024Internship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}})));
        //System.out.println(Arrays.toString(new Solution().solution(new int[][]{{1,2},{2,3},{3,4},{4,5},{5,6},{6,2},{1,7},{7,8},{8,9},{9,10}})));
    }

    //입출력 : [a,b] a번 정점에서 b번 정점으로 향하는 간선있다
    //edges 길이는 1000000
    static class Solution {
        static boolean[] visit;
        public int[] solution(int[][] edges) {
            HashMap<Integer, Node> nodes = new HashMap<>();
            for(int i=0;i<edges.length;i++){
                int[] edge = edges[i];
                int start = edge[0];
                int end = edge[1];

                if(start==end){
                    Node startNode = nodes.getOrDefault(start, new Node(start));
                    startNode.childNodes.add(start);
                    startNode.parents.add(start);
                    nodes.put(start,startNode);
                    continue;
                }
                Node startNode = nodes.getOrDefault(start, new Node(start));
                Node endNode = nodes.getOrDefault(end, new Node(end));

                startNode.childNodes.add(end);
                endNode.parents.add(start);

                nodes.put(start,startNode);
                nodes.put(end,endNode);
            }

            List<Node> collect = nodes.values().stream().filter(node -> node.parents.size() == 0 && node.childNodes.size()!=1).collect(Collectors.toList());
            Node createdNode = collect.get(0);
            for(Integer child:createdNode.childNodes){
                Node node = nodes.get(child);
                node.parents.remove(node.parents.indexOf(createdNode.nodeNumber));
            }

            int[] answer = new int[4];
            answer[0]=createdNode.nodeNumber;

            visit=new boolean[100_0000];
            for(Integer child:createdNode.childNodes){
                answer[dfs(nodes.get(child),nodes)]++;
            }

            return answer;
        }

        private int dfs(Node node, HashMap<Integer, Node> nodes) {
            if(node.childNodes.size()==0){
                return 2;
            }
            if(node.childNodes.size()!=1){
                return 3;
            }
            if(visit[node.nodeNumber]) return 1;
            visit[node.nodeNumber]=true;

            return dfs(nodes.get(node.childNodes.get(0)), nodes);
        }

        static class Node{
            int nodeNumber;
            ArrayList<Integer> parents;
            ArrayList<Integer> childNodes;

            public Node(int nodeNumber){
                this.nodeNumber=nodeNumber;
                parents=new ArrayList<>();
                childNodes=new ArrayList<>();
            }
        }
    }

}
