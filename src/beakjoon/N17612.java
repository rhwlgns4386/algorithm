package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class N17612 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        Queue<Customer> customers = new LinkedList<>();
        for(int i=0;i<N;i++){
            st=new StringTokenizer(in.readLine());
            int id=Integer.parseInt(st.nextToken());
            int time=Integer.parseInt(st.nextToken());
            customers.add(new Customer(id,time,0));
        }

        PriorityQueue<Time> endQ = new PriorityQueue<>();
        PriorityQueue<Customer> outputQ = new PriorityQueue<>();

        int orderCount=0;
        for(int i=0;i<Math.min(N,K);i++){
            Customer customer = customers.remove();
            endQ.add(new Time(customer.time,orderCount%K));
            outputQ.add(new Customer(customer.id, customer.time, orderCount%K));
            orderCount++;
        }

        while (!customers.isEmpty()){
            Time here = endQ.remove();
            Customer customer = customers.remove();

            outputQ.add(new Customer(customer.id, customer.time+here.time,here.table));
            endQ.add(new Time(customer.time+here.time,here.table));
        }

        long result=0;
        for(long i=1;i<=N;i++){
            Customer here = outputQ.remove();
            result+=here.id*i;
        }

        System.out.println(result);
    }

    static class Time implements Comparable<Time>{
        int time;
        int table;

        public Time(int time, int table) {
            this.time = time;
            this.table = table;
        }

        @Override
        public int compareTo(Time o) {
            if(time<o.time){
                return -1;
            } else if (time==o.time) {
                return table-o.table;
            }else{
                return 1;
            }
        }
    }

    static class Customer implements Comparable<Customer>{


        int id;
        int time;
        int table;

        public Customer(int id, int time, int table) {
            this.id = id;
            this.time = time;
            this.table = table;
        }

        @Override
        public int compareTo(Customer o) {
            if(time<o.time){
                return -1;
            } else if (time==o.time) {
                return o.table - table;
            }else{
                return 1;
            }
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "id=" + id +
                    ", time=" + time +
                    ", order=" + table +
                    '}';
        }
    }
}
