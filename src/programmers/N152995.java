package programmers;

import java.util.*;

public class N152995 {

    static class User{
        int number;
        int workAttitude;
        int peerScore;
        public User(int number,int workAttitude,int peerScore) {
            this.number=number;
            this.workAttitude=workAttitude;
            this.peerScore=peerScore;
        }

        @Override
        public String toString() {
            return "User{" +
                    "number=" + number +
                    '}';
        }
    }

    public static int solution(int[][] scores) {
        int answer = 0;
        int[][] a = new int[100000+1][100000+1];

        int maxWorkAttitude=0;
        int maxPeerScore=0;
        for(int i=0;i<scores.length;i++){
            int workAttitude=scores[i][0];
            int peerScore=scores[i][1];

            a[0][0]+=1;
            a[workAttitude+1][0]-=1;
            a[0][peerScore]-=1;
            a[workAttitude+1][peerScore+1]+=1;

            maxPeerScore=Math.max(peerScore,maxPeerScore);
            maxWorkAttitude=Math.max(workAttitude,maxWorkAttitude);
        }

        for(int i=0;i<maxWorkAttitude;i++){
            for(int j=1;j<maxWorkAttitude;j++){
                a[i][j]+=a[i][j-1];
            }
        }

        for(int i=0;i<maxPeerScore;i++){
            for(int j=1;j<maxWorkAttitude;j++){
                a[j][i]+=a[j][i-1];
            }
        }

        ArrayList<User> users = new ArrayList<>();
        for(int i=0;i<scores.length;i++){
            if(a[scores[i][0]][scores[i][1]]==0){
                users.add(new User(i,scores[i][0],scores[i][1]));
            }
        }

        users.sort((o1, o2) -> {
            int o1Sum = o1.peerScore + o1.workAttitude;
            int o2Sum = o2.peerScore + o2.workAttitude;
            if(o1Sum>o2Sum){
                return -1;
            }else if(o1Sum==o2Sum){
                if(o1.number>o2.number){
                    return 1;
                }else{
                    return -1;
                }
            }
            else{
                return 1;
            }}
        );

        for(int i=0;i<users.size();i++){
            if(users.get(i).number==0){
                return i+1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println( solution(new int[][]{{5,5},{20,1},{10,9},{10,10}}));
    }
}
