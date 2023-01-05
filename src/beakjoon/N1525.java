package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N1525 {
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    public static int finish=123456789;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int start=0;
        StringTokenizer st;
        for(int i=0;i<3;i++){
            st=new StringTokenizer(in.readLine());
            for(int j=0;j<3;j++){
                int temp=Integer.parseInt(st.nextToken());
                if(temp==0){
                    temp=9;
                }
                start=start*10+temp;
            }
        }

        if(start==finish){
            System.out.println("0");
            return;
        }
//        bidirectional(start);
//        System.out.println(ids(start,1));
        System.out.println(memoizedIds(start,5,1));
    }

    static int best=0;
    static HashMap<Integer,Integer> cache=new HashMap<>();

    public static int memoizedIds(int start, int cacheLevels, int growthStep) {
        if(cacheLevels > 0 && cache.size() == 0)
            fillCache(finish, cacheLevels);

        for(int limit = 4; limit<36; limit += growthStep) {
            best = limit+1;
            memoizingDFS(start, 0);
            if(best <= limit) return best;
        }
        return -1;
    }

    private static void memoizingDFS(int start,int step) {
        if(step>=best) return;

        if(finish==start) best=step;

        if(cache.containsKey(start)){
            best=Math.min(best,cache.get(start));
            return;
        }

        String now=Integer.toString(start);
        int zeroIndex = now.indexOf("9");
        int x=zeroIndex/3;
        int y=zeroIndex%3;

        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx<0 || 3<=nx || ny<0 || 3<=ny) continue;

            StringBuilder next = new StringBuilder(now);
            next.setCharAt(x*3+y,next.charAt(nx*3+ny));
            next.setCharAt(nx*3+ny,'9');
            dfs(Integer.parseInt(next.toString()),step+1);
        }
    }

    private static void fillCache(int start, int cacheLevels) {
        LinkedList<Integer> q = new LinkedList<>();
        q.push(start);
        cache.put(start,0);

        while (!q.isEmpty()){
            Integer fzState = q.remove();
            String now=Integer.toString(fzState);
            int zeroIndex = now.indexOf("9");
            int x=zeroIndex/3;
            int y=zeroIndex%3;

            if(cache.get(fzState)==cacheLevels) break;

            for (int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(nx<0 || 3<=nx || ny<0 || 3<=ny) continue;
                StringBuilder next = new StringBuilder(now);
                next.setCharAt(x*3+y,next.charAt(nx*3+ny));
                next.setCharAt(nx*3+ny,'9');

                int num=Integer.parseInt(next.toString());
                if(!cache.containsKey(num)){
                    cache.put(num,cache.get(fzState)+1);
                    q.push(num);
                }
            }
        }
    }

    public static int ids(int start,int growStep){
        for(int limit=4;;limit+=growStep){
            best=limit+1;
            dfs(start,0);
            if(best<=limit) return best;
        }
    }

    public static void dfs(int start,int step){
        if(step>=best) return;

        if(finish==start) best=step;

        String now=Integer.toString(start);
        int zeroIndex = now.indexOf("9");
        int x=zeroIndex/3;
        int y=zeroIndex%3;

        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx<0 || 3<=nx || ny<0 || 3<=ny) continue;

            StringBuilder next = new StringBuilder(now);
            next.setCharAt(x*3+y,next.charAt(nx*3+ny));
            next.setCharAt(nx*3+ny,'9');
            dfs(Integer.parseInt(next.toString()),step+1);
        }
    }

    static int sgn(int x) { if(x < 0) return -1; if(x > 0) return 1; return 0; }

    static int incr(int x) { if(x < 0) return x-1; return x+1; }


    private static void bidirectional(int start){
        HashMap<Integer, Integer> d = new HashMap<>();
        LinkedList<Integer> q = new LinkedList<>();

        d.put(start,1);
        q.add(start);
        d.put(finish,-1);
        q.add(finish);

        while (!q.isEmpty()){
            Integer fzState = q.remove();
            String now=Integer.toString(fzState);
            int zeroIndex = now.indexOf("9");
            int x=zeroIndex/3;
            int y=zeroIndex%3;

            for (int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(nx<0 || 3<=nx || ny<0 || 3<=ny) continue;

                StringBuilder next = new StringBuilder(now);
                next.setCharAt(x*3+y,next.charAt(nx*3+ny));
                next.setCharAt(nx*3+ny,'9');

                int num=Integer.parseInt(next.toString());
                if(!d.containsKey(num)){
                    d.put(num,incr(d.get(fzState)));
                    q.add(num);
                }else if(sgn(d.get(num))!=sgn(d.get(fzState))){
                    System.out.println(Math.abs(d.get(num))+Math.abs(d.get(fzState))-1);
                    return;
                }
            }
        }

        System.out.println("-1");
        return;
    }

    private static void bfs(int start) {
        HashMap<Integer, Integer> d = new HashMap<>();
        LinkedList<Integer> q = new LinkedList<>();

        d.put(start,0);
        q.add(start);

        while (!q.isEmpty()){
            Integer fzState = q.remove();
            String now=Integer.toString(fzState);
            int zeroIndex = now.indexOf("9");
            int x=zeroIndex/3;
            int y=zeroIndex%3;

            for (int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(nx<0 || 3<=nx || ny<0 || 3<=ny) continue;

                StringBuilder next = new StringBuilder(now);
                next.setCharAt(x*3+y,next.charAt(nx*3+ny));
                next.setCharAt(nx*3+ny,'9');

                int num=Integer.parseInt(next.toString());
                if(!d.containsKey(num)){
                    d.put(num,d.get(fzState)+1);
                    q.add(num);
                }
            }
        }

        if(d.containsKey(finish)){
            System.out.println(d.get(finish));
        }else{
            System.out.println("-1");
        }
    }
}
