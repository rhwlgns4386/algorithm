package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N2109 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, PriorityQueue<Integer>> map= new HashMap<>();

        int n=Integer.parseInt(in.readLine());

        for (int i = 0; i <n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(in.readLine(), " ");

            int p=Integer.parseInt(stringTokenizer.nextToken());
            int d=Integer.parseInt(stringTokenizer.nextToken());

            if(map.containsKey(d)){
                map.get(d).add(p);
            }
            else {
                PriorityQueue<Integer> queue=new PriorityQueue<>(Comparator.reverseOrder());
                queue.add(p);
                map.put(d,queue);
            }
        }

        int sum = map.entrySet().stream().mapToInt(ary -> ary.getValue().poll()).sum();
        System.out.println(sum);
    }
}
