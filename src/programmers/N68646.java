package programmers;

import java.util.Arrays;

public class N68646 {

    static final int MAX_VALUE=1000000001;
    public static void main(String[] args) {
        System.out.println( new N68646().solution(new int[]{-16,27,65,-2,58,-92,-71,-68,-61,-33}));
    }

    public int solution(int[] a) {

        int[] leftMin=new int[a.length];
        Arrays.fill(leftMin,MAX_VALUE);
        leftMin[0]=a[0];
        for(int i=1;i<a.length;i++){
            leftMin[i]=Math.min(leftMin[i-1],a[i]);
        }

        int[] rightMin=new int[a.length];
        Arrays.fill(rightMin,MAX_VALUE);
        rightMin[a.length-1]=a[a.length-1];
        for(int i=a.length-2;0<=i;i--){
            rightMin[i]=Math.min(rightMin[i+1],a[i]);
        }

        int minValueIdx=0;
        int minValue=a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]<minValue){
                minValue=a[i];
                minValueIdx=i;
            }
        }

        int answer = 0;
        for(int i=0;i<a.length;i++){
            if(i<minValueIdx){
                if(leftMin[i]==a[i]){
                    answer++;
                }
            }else{
                if(rightMin[i]==a[i]){
                    answer++;
                }
            }
        }
        return answer;
    }
}
