package programmers;

public class N49995 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1,1,2,3}));
        System.out.println(solution.solution(new int[]{1,2,4,5}));
    }

    static class Solution {
        public int solution(int[] cookie) {
            int answer = 0;
            int[] sums=new int[cookie.length];
            sums[0]=cookie[0];
            //0 1 2 3 4 5
            //짝수여야 가능함
            for(int i=1;i<cookie.length;i++){
                sums[i]=sums[i-1]+cookie[i];
                for(int j=-1;j<i-1;j++){
                    int temp=sums[i];
                    if(j!=-1){
                        temp-=sums[j];
                    }
                    if(temp%2==0){
                        int lo=j+1;
                        int hi=i;
                        int minusNumber=0;
                            if(j!=-1){
                                minusNumber=sums[j];
                            }
                        while (lo+1<hi){
                            int mid=(lo+hi)/2;
                            if(sums[mid]-minusNumber<=temp/2){
                                lo=mid;
                            }else{
                                hi=mid;
                            }
                        }
                        if(sums[lo]-minusNumber==temp/2){
                            answer=Math.max(temp/2,answer);
                        }
                    }
                }
            }
            return answer;
        }
    }

}
