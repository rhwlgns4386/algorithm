import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class N10815 {
    public static ArrayList<Integer> list=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer=new StringTokenizer(bufferedReader.readLine()," ");
        for(int i=0;i<N;i++){
            int card = Integer.parseInt(stringTokenizer.nextToken());
            list.add(card);
        }
        list.sort(Comparator.naturalOrder());
        Integer M = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer2=new StringTokenizer(bufferedReader.readLine()," ");
        for(int i=0;i<M;i++){
            System.out.print(binarySearch(Integer.parseInt(stringTokenizer2.nextToken()))+" ");
        }
    }

    public static int binarySearch(Integer findInt){
        int left=0;
        int right=list.size()-1;
        int mid;
        while (left<=right) {
            mid=(left+right)>>>1;
            int minVal=list.get(mid);
            if (findInt < minVal) {
                right = mid - 1;
            } else if(findInt>minVal){
                left=mid+1;
            }
            else{
                return 1;
            }

        }
        return 0;
    }
}
