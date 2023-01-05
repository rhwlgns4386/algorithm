package groom.week4;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        LinkedList<Integer> q = new LinkedList<>();

        for(int i=0;i<m;i++){
            while (!q.isEmpty()&&((n-q.peek())>=0)){
                n-=q.remove();
            }
            String input = br.readLine();
            String[] s = input.split(" ");
            if(s[0].equals("deposit")){
                n+=Integer.parseInt(s[1]);
            }else if(s[0].equals("pay")){
                int p = Integer.parseInt(s[1]);
                if((n-p)>=0){
                    n-=p;
                }
            }else{
                int p = Integer.parseInt(s[1]);
                if((n-p)>=0){
                    n-=p;
                }else{
                    q.add(p);
                }
            }
        }
        while (!q.isEmpty()&&((n-q.peek())>=0)){
            n-=q.remove();
        }
        System.out.println(n);
    }
}
