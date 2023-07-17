package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class N2493 {
    static class Pair implements Comparable<Pair>{
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int compareTo(Pair p){
            return Integer.compare(this.first,p.first);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(in.readLine());
        int[] a=new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i=n-1;0<=i;i--){
            a[i]=Integer.parseInt(st.nextToken());
        }

        int[] result=new int[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            while(!pq.isEmpty() && pq.peek().first<a[i]){
                Pair node = pq.remove();
                result[node.second]=n-i;
            }

            pq.add(new Pair(a[i],i));
        }

        for(int i=n-1;0<=i;i--){
            System.out.print(result[i]+" ");
        }
    }
}
