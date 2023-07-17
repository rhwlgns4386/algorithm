package programmers;

import java.util.*;

class Solution {
    static class Node implements Comparable<Node> {
        int start;
        int end;
        int time;

        public Node(int start,int end){
            this.start=start;
            this.end=end;
            time=end-start;
        }

        @Override
        public int compareTo(Node o) {
            return 0;
        }
    }
    public static char[] alpavit={'A','E','I','O','U'};
    public static int cnt=0;

    public static void main(String[] args) {
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(0,4));
        pq.add(new Node(1,4));
        System.out.println(pq.remove().start);
    }
}
