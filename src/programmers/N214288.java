package programmers;

import java.util.Arrays;

public class N214288 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3,5,new int[][]{{10, 60, 1}, {15, 100, 3}, {20, 30, 1}, {30, 50, 3}, {50, 40, 1}, {60, 30, 2}, {65, 30, 1}, {70, 100, 2}}));
        System.out.println(solution.solution(2,3,new int[][]{{5, 55, 2}, {10, 90, 2}, {20, 40, 2}, {50, 45, 2}, {100, 50, 2}}));
        System.out.println(solution.solution(1,1,new int[][]{{1, 100, 1}, {2, 100, 1}, {3, 100, 1}, {4, 100, 1}, {5, 100, 1}}));
        System.out.println(solution.solution(1,1,new int[][]{{1, 100, 1}}));
    }

    static class Solution {
        /*
        상담은 1:1
        멘토 : n명 (k<=n<=20)
        상담 유형 : k번까지(1<=k<=5)
        상담 대기 시간 : 상담 시작시간 - 상담 요청시간
        우선 순위 : 같은 유형의 상담은 먼저 요청한 사람이 우선순위
        풀고자 하는 문제 : 대기시간의 합이 최소가 되도록 멘토 인원 배정

        입력 :
        n : (k<=n<=20)
        k : (1<=k<=5)
        reqs(신청 인원) : 3<=reqs<=300
        a(시작시간) : 1<=a<=1,000
        b(상담시간) : 1<=b<=100
        c(신청 상담유형) :1<=c<=k
        */
//        static int MAX=Integer.MAX_VALUE;
        static int result=Integer.MAX_VALUE;
        public int solution(int k, int n, int[][] reqs) {
            int[] member=new int[k];
            Arrays.fill(member,1);
            go(k,n,n-k,reqs,member,0);
            return result;
        }

        private void go(int k, int n, int remaining, int[][] reqs, int[] member, int deeps) {
            if(deeps==k){
                int[] delay=new int[k];
                int[][] workingTable=new int[k][n];

                for(int[] user:reqs){
                    int a = user[0];
                    int b = user[1];
                    int c = user[2]-1;

                    int minTime=Integer.MAX_VALUE;
                    int minTimeIdx=-1;
                    for(int i=0;i<member[c];i++){
                        if(workingTable[c][i]<minTime){
                            minTime=workingTable[c][i];
                            minTimeIdx=i;
                        }
                    }

                    if(minTime<=a){
                        workingTable[c][minTimeIdx]=a+b;
                    }else{
                        delay[c]+=minTime-a;
                        workingTable[c][minTimeIdx]=minTime+b;
                    }
                }

                result=Math.min(result,Arrays.stream(delay).sum());
                return;
            }

            for(int i=0;i<=remaining;i++){
                member[deeps]+=i;
                go(k,n,remaining-i,reqs,member,deeps+1);
                member[deeps]=1;
            }
        }
    }
}

//        private int canThisWaitingTime(int k, int n, int[][] reqs) {
//            int[] consultant=new int[k];
//            Arrays.fill(consultant,1);
//
//            int count=n-Arrays.stream(consultant).sum();
//            int totalDelay=0;
//            while (-1<count){
//                int[] delay=new int[k];
//                int[][] workingTable=new int[k][n];
//                for(int[] user:reqs){
//                    int a = user[0];
//                    int b = user[1];
//                    int c = user[2]-1;
//
//                    int minTime=MAX;
//                    int minTimeIdx=-1;
//                    for(int i=0;i<consultant[c];i++){
//                        if(workingTable[c][i]<=minTime){
//                            minTime=workingTable[c][i];
//                            minTimeIdx=i;
//                        }
//                    }
//
//                    if(minTime<a){
//                        workingTable[c][minTimeIdx]=a+b;
//                    }else{
//                        delay[c]+=minTime-a;
//                        workingTable[c][minTimeIdx]=minTime+b;
//                    }
//                }
//
//                totalDelay= Arrays.stream(delay).sum();
//
//                int maxDelay=0;
//                int maxDelayIdx=0;
//
//                for(int i=0;i<k;i++){
//                    if(maxDelay<=delay[i]){
//                        maxDelay=delay[i];
//                        maxDelayIdx=i;
//                    }
//                }
//
//                consultant[maxDelayIdx]++;
//                count--;
//            }
//
//            return totalDelay;
//        }
