package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N1202_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        int n=Integer.parseInt(stringTokenizer.nextToken());
        int v=Integer.parseInt(stringTokenizer.nextToken());

        LinkedList<Pair> items = new LinkedList<>();
        for(int i=0;i<n;i++){
            stringTokenizer=new StringTokenizer(in.readLine());
            int weight=Integer.parseInt(stringTokenizer.nextToken());
            int price=Integer.parseInt(stringTokenizer.nextToken());
            items.add(new Pair(price,weight));
        }
        Collections.sort(items);

        ArrayList<Integer> backs= new ArrayList<>();
        for(int i=0;i<v;i++){
           backs.add(Integer.parseInt(in.readLine()));
        }
        Collections.sort(backs);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long ans=0;
        for(Integer weight:backs){
            while (!items.isEmpty() && items.peek().second<=weight){
                pq.add(items.remove().first);
            }

            if(!pq.isEmpty()){
                ans+=pq.remove();
            }
        }
        System.out.println(ans);
    }

    static class Pair implements Comparable<Pair>{
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            return second-o.second;
        }
    }
}
