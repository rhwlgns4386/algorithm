package programmers;

public class N60062 {

    static N60062 main=new N60062();
    private static final int MAX_MEMBER_COUNT =10;

    public static void main(String[] args) {

        testing(12,new int[]{1, 5, 6, 10},new int[]{1,2,3,4},2);
        testing(12,new int[]{1, 2, 5, 6, 10},new int[]{1,2,3,4},2);
        testing(12,new int[]{1, 3, 4, 9, 10},new int[]{3, 5, 7},1);
        testing(12,new int[]{1, 3, 4, 9, 10},new int[]{3, 5, 7,12},1);
        testing(200,new int[]{0, 10, 50, 80, 120, 160},new int[]{1, 5, 10 , 30 , 40},3);
        testing(200,new int[]{0, 10, 50, 80, 120, 160},new int[]{1},-1);
        testing(2,new int[]{160},new int[]{1},1);
    }

    private static void testing(int n, int[] weak, int[] dist, int result) {
        int solution = main.solution(n, weak, dist);

        if(result==solution){
            System.out.println("성공");
        }else{
            System.out.println("실패" + " result : "+solution);
        }
    }

    public int solution(int n, int[] weak, int[] dist) {
        int result= MAX_MEMBER_COUNT;
        for(int i=0;i<weak.length;i++){
            weak=rotate(n,weak);
            result=Math.min(go(weak,dist,0,new boolean[dist.length]),result);
        }

        return result==MAX_MEMBER_COUNT?-1:result;
    }

    private int go(int[] weak, int[] dist, int next, boolean[] visit) {
        if(weak.length==next) return 0;
        if(!canGo(visit)) return MAX_MEMBER_COUNT;

        int result= MAX_MEMBER_COUNT;
        for(int i=0;i<dist.length;i++){
            if(!visit[i]){
                visit[i]=true;
                result=Math.min(result,go(weak,dist,findNext(weak, next, dist[i]),visit)+1);
                visit[i]=false;
            }
        }

        return result;
    }

    private boolean canGo(boolean[] visit) {
        for(int i=0;i<visit.length;i++){
            if(!visit[i]) return true;
        }

        return false;
    }

    private int findNext(int[] weak, int next, int dist) {
        int nextDist = weak[next] + dist;
        for(int i=0;i<weak.length;i++){
            if(weak[i]<=nextDist) continue;
            return i;
        }

        return weak.length;
    }

    private int[] rotate(int n, int[] weak) {
        int size = weak.length;
        int[] rotate = new int[size];
        int lastItem = weak[size - 1];
        int dist = n - lastItem;

        for(int i=0;i<size;i++){
            rotate[i]=(weak[(size-1+i)%size]+dist)%n;
        }

        return rotate;
    }
}
