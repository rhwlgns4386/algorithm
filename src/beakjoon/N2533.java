package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N2533 {
    static int count=0;
    private static HashMap<Integer, ArrayList<Integer>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());

        map = new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i,new ArrayList<>());
        }

        for(int i=0;i<n-1;i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());

            map.get(start).add(end);
            map.get(end).add(start);
        }

        boolean[] visit=new boolean[n+2];
        postorderTraversal(1,visit);
        System.out.println(count);
    }

    private static boolean postorderTraversal(int node,boolean[] visit) {
        ArrayList<Integer> childs = map.get(node);
        visit[node]=true;
        boolean flag=true;
        for(Integer child:childs){
            if(!visit[child]){

                if(!postorderTraversal(child,visit)) flag=false;
            }
        }

        if(flag){
           return false;
        }

        count++;
        return true;
    }
}
