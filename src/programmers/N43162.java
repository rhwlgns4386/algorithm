package programmers;

public class N43162 {
    public static void main(String[] args) {
        System.out.println(solution(3,new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visit[i]){
                answer++;
                dfs(computers,visit,i);
            }
        }
        return answer;
    }

    private static void dfs(int[][] computers, boolean[] visit, int node) {
        visit[node]=true;
        for(int i=0;i<computers[0].length;i++){
            if(!visit[i]&&computers[node][i]==1){
                dfs(computers,visit,i);
            }
        }
    }
}
