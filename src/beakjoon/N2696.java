package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(in.readLine());
        while (T-->0){
            int N=Integer.parseInt(in.readLine());
            PriorityQueue<Integer> minQ = new PriorityQueue<>();
            PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
            StringBuffer stringBuffer = new StringBuffer();
            int x = (N - 1) / 10;
            for(int i=0;i<=x;i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                int y= Math.min(N - (i * 10), 10);
                for (int j = 0; j <y; j++) {
                    int here = Integer.parseInt(st.nextToken());
                    if(maxQ.isEmpty() || here<maxQ.peek()){
                        maxQ.add(here);
                    }else{
                        minQ.add(here);
                    }
                    while (((j+1)%2==0 && maxQ.size()!=minQ.size()) || ((j+1)%2!=0 && maxQ.size()!=(minQ.size()+1))){
                        if(maxQ.size()<minQ.size()){
                            maxQ.add(minQ.remove());
                        }else{
                            minQ.add(maxQ.remove());
                        }
                    }
                    if((j+1)%2!=0){
                        stringBuffer.append(maxQ.peek());
                        stringBuffer.append(" ");
                    }
                }
            }
            System.out.println((int)Math.ceil(N/2.0f));
            System.out.println(stringBuffer);
        }
    }

}
