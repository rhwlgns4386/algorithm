package beakjoon;

import java.util.*;

public class N11053 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] A = new int[n];
        for(int i=0;i<n;i++){
            A[i]=in.nextInt();
        }

        ArrayList<Integer> al = new ArrayList<>();

        for(int i=0;i<n;i++){
            int pos = Collections.binarySearch(al, A[i]);
            if(pos<0) pos=-(pos+1);
            if(al.size()<=pos) al.add(A[i]);
            else al.set(pos,A[i]);
        }

        System.out.println(al.size());
    }
}
