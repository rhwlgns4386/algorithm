package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N1946 {
    static class Pair{
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(in.readLine());
        while (T-->0){
            int n = Integer.parseInt(in.readLine());

            ArrayList<Pair> a = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(in.readLine());
                int first=Integer.parseInt(st.nextToken());
                int second=Integer.parseInt(st.nextToken());

                a.add(new Pair(first,second));
            }

            Collections.sort(a,((o1, o2) -> Integer.compare(o1.first,o2.first)));
            int second = a.get(0).second;
            int count=1;
            for(int i=1;i<n;i++){
                Pair pair = a.get(i);
                if(pair.second<second){
                    second=pair.second;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
