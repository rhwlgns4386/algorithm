//package programmers.kakao2023BlindRecuruitment;
//
//import java.util.Arrays;
//
//public class N4 {
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(new long[]{111})));;
//    }
//    public static int[] solution(long[] numbers) {
//        int[] answer = new int[numbers.length];
//        for(int i=0;i<numbers.length;i++){
//            if(binarySearch(Long.toBinaryString(numbers[i]),0)==0) answer[i]=1;
//            else answer[i]=0;
//        }
//        return answer;
//    }
//    public static int binarySearch(String binaryString, int index){
//        int len=binaryString.length();
//        int mid=0;
//        if(len==0) return index-1;
//        if(len==1) {
//            if(binaryString.charAt(0)=='0'){
//                return index-1;
//            }
//            return index;
//        }
//        if(len%2==0){
//            mid=len/2-1;
//        }
//        else {
//            mid=len/2;
//        }
//
//        if(binaryString.charAt(mid)=='0') return index-1;
//        int left=index;
//        if(len%2!=0){
//            left=binarySearch(binaryString.substring(0,mid),index+1);
//        }
//
//        int right=binarySearch(binaryString.substring(mid+1,len),index+1);
//
//
//
//    }
//}
