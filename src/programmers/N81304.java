package programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class N81304 {
    static class Solution {

        public int solution(int n, int start, int end, int[][] roads, int[] traps) {
            int answer = 0;

            HashMap<Integer, ArrayList<Load>> map = new HashMap<>();
            for(int i=0;i<roads.length;i++){
                int P = roads[i][0];
                int Q = roads[i][1];
                int S = roads[i][2];

                Load load = new Load(P, Q, S, P);
                if(map.containsKey(P)){
                    map.put(P,new ArrayList<>());
                }
                if(map.containsKey(Q)){
                    map.put(Q,new ArrayList<>());
                }
                map.get(P).add(load);
                map.get(Q).add(load);
            }


            return answer;
        }

        static class Load{
            int start;
            int end;
            int weight;
            int entrance;

            public Load(int start, int end, int weight, int entrance) {
                this.start = start;
                this.end = end;
                this.weight = weight;
                this.entrance = entrance;
            }

            public void changeEntrance(){
                if(this.entrance==start){
                    this.entrance=end;
                    return;
                }
                this.entrance=start;
            }
        }

        static class Pair{
            int node;
            int weight;

            public Pair(int node, int weight) {
                this.node = node;
                this.weight = weight;
            }
        }
    }
}
