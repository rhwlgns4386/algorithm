package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class N12978 {
    static class Solution {
        public int solution(int N, int[][] road, int K) {
            int answer = 0;
            ArrayList<ArrayList<Node>> adj= new ArrayList<>();
            for(int i=0;i<N+1;i++){
                adj.add(new ArrayList<>());
            }
            for(int i=0;i<road.length;i++){
                int[] info=road[i];
                int start=info[0];
                int end=info[1];
                int dist=info[2];

                adj.get(start).add(new Node(end,dist));
                adj.get(end).add(new Node(start,dist));
            }

            PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->Integer.compare(a.weight,b.weight));
            pq.add(new Node(1,0));

            int[] dist=new int[N+1];
            Arrays.fill(dist,Integer.MAX_VALUE);
            dist[1]=0;
            while (!pq.isEmpty()){
                Node here = pq.remove();

                if(dist[here.nodeNuber]<here.weight)continue;
                for(Node next:adj.get(here.nodeNuber)){
                    if(dist[next.nodeNuber]> here.weight+next.weight){
                        dist[next.nodeNuber]=here.weight+next.weight;
                        pq.add(new Node(next.nodeNuber, dist[next.nodeNuber]));
                    }
                }
            }

            int count=0;
            for(int i=2;i<N+1;i++){
                if(dist[i]<=K)count++;
            }
            return count;
        }

        static class Node{
            int nodeNuber;
            int weight;

            public Node(int nodeNuber, int weight) {
                this.nodeNuber = nodeNuber;
                this.weight = weight;
            }
        }
    }
}
