package groom.week3;

import java.util.*;
import java.io.*;

public class N4 {
    public static int[] check=new int[10101];
    public static ArrayList<Integer>[] graph=(ArrayList<Integer>[]) new ArrayList[10101];
    public static ArrayList<Integer>cycle=new ArrayList<>();
    public static int finish=-1;

    public static void main(String[] args) throws Exception{
        for (int i=0;i<10101;++i){
            graph[i]=new ArrayList<>();
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
        StringTokenizer st;
        for(int i=0;i<n;++i){
            st= new StringTokenizer(in.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        FindCycle(1,1);

        Collections.sort(cycle);

        System.out.println(cycle.size());
        for(Integer i:cycle){
            System.out.print(i+" ");
        }
    }

    static void FindCycle(int node,int begin){
        if(check[node]==1){
            finish=node;
            cycle.add(node);
            return ;
        };
        check[node]=1;
        for(int y:graph[node]){
            if(y==begin) continue;
            FindCycle(y,node);
            if(finish==-2) return;
            if(finish==node){
                finish=-2;
                return;
            }
            if(finish>=0){
                cycle.add(node);
                return;
            }
        }
    }
}
