package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N12100 {

    private static int n;

    private static HashSet<ArrayList<Integer>> set=new HashSet<>();
    private static int MAX;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());

        ArrayList<Integer> map=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; j++) {
                map.add(Integer.parseInt(st.nextToken()));
            }
        }
        MAX=findMax(map);
        go(map, 5);
        System.out.println(MAX);
    }

    private static void go(ArrayList<Integer> a, int count) {
        if (count == 0) {
            MAX=Math.max(findMax(a),MAX);
            return;
        }

        int result =findMax(a);
        MAX=Math.max(result,MAX);
        if((result*(2<<count-1))<=MAX) return;

        for (int i = 0; i < 4; i++) {
            ArrayList<Integer> next = move(a, i);
            if(set.contains(next)) continue;
            set.add(next);
            go(next,count-1);
            set.remove(next);
        }
    }

    private static int findMax(ArrayList<Integer> a) {
        int max=0;
        for(Integer i:a){
            max=Math.max(i,max);
        }
        return max;
    }


    static int[] dx = {0, 0, -1, -1};
    static int[] dy = {-1, -1, 0, 0};

    private static ArrayList<Integer> move(ArrayList<Integer> map, int type) {
        ArrayList<Integer> copyMap;
        if(type==0 || type==2){
            copyMap=new ArrayList<>(map);
        }else{
            copyMap=swap(map);
        }

        boolean[] visit = new boolean[copyMap.size()];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int idx=calcIdx(i,j);
                if (copyMap.get(idx) != 0) {
                    int nx=i+dx[type];
                    int ny=j+dy[type];
                    int nIdx=calcIdx(nx,ny);
                    while (true) {

                        if (!inRange(nx,ny)) {
                            if(calcIdx(nx-dx[type],ny-dy[type])==idx) break;
                            copyMap.set(calcIdx(nx-dx[type],ny-dy[type]),copyMap.get(idx));
                            copyMap.set(idx,0);
                            break;
                        }

                        if (copyMap.get(nIdx) != 0) {
                            if (copyMap.get(nIdx).equals(copyMap.get(idx)) &&!visit[nIdx]) {
                                copyMap.set(nIdx,copyMap.get(idx)*2);
                                copyMap.set(idx,0);
                                visit[nIdx]=true;
                            } else {
                                if(calcIdx(nx-dx[type],ny-dy[type])==idx) break;
                                copyMap.set(calcIdx(nx-dx[type],ny-dy[type]),copyMap.get(idx));
                                copyMap.set(idx,0);
                            }
                            break;
                        }

                        nx+=dx[type];
                        ny+=dy[type];
                        nIdx=calcIdx(nx,ny);
                    }
                }
            }
        }
        if(type==1 || type==3){
            copyMap=swap(copyMap);
        }

        return copyMap;
    }

    private static boolean inRange(int x,int y) {
        return 0<=x && x<n && 0<=y && y<n;
    }

    private static int calcIdx(int x, int y) {
        return x*n+y;
    }

    private static ArrayList<Integer> swap(ArrayList<Integer> a) {
        ArrayList<Integer> copy = new ArrayList<>();
        for(int i=a.size()-1;0<=i;i--){
            copy.add(a.get(i));
        }
        return copy;
    }

}
