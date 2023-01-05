package programmers;

public class N64062 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1},3));
    }
    public static int solution(int[] stones, int k) {
        int answer = 0;
        answer=binarySearch(stones,k);
        return answer;
    }

    private static int binarySearch(int[] stones, int k) {
        int left=1;
        int right=200000000;
        int answer=0;
        while (left<=right){
            int mid=(left+right)/2;
            if(canMove(stones,k,mid)){
                left=mid+1;
                answer=Math.max(answer,mid);
            }else{
                right=mid-1;
            }
        }
        return answer;
    }

    private static boolean canMove(int[] stones, int k, int mid) {
        int cnt=0;
        for(int i=0;i<stones.length;i++){
            if((stones[i]-mid)<0){
                cnt++;
            }else{
                cnt=0;
            }

            if(cnt==k){
                return false;
            }
        }
        return true;
    }
}
