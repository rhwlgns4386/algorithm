package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N14892 {
    static class Gear{
        int[] state;
        int twelveIndex=0;
        Gear left;
        Gear right;

        public Gear(int[] state) {
            this.state = state;
        }

        public void setLeft(Gear left) {
            this.left = left;
        }

        public void setRight(Gear right) {
            this.right = right;
        }

        public void addLeft(Gear left) {
            left.setRight(this);
            this.setLeft(left);
        }
        public void rotation(int direction){
            if(left!=null && left.isRotateRightIdx(state[getLeftIndex()])){
                left.rotationLeft(direction*-1);
            }
            if(right!=null && right.isRotateLeftIdx(state[getRightIndex()])){
                right.rotationRight(direction*-1);
            }

            twelveIndex=cacIdx(direction*-1);
        }

        private void rotationRight(int direction) {
            if(right!=null && right.isRotateLeftIdx(state[getRightIndex()])){
                right.rotationRight(direction*-1);
            }

            twelveIndex=cacIdx(direction*-1);
        }

        private void rotationLeft(int direction) {
            if(left!=null && left.isRotateRightIdx(state[getLeftIndex()])){
                left.rotationLeft(direction*-1);
            }
            twelveIndex=cacIdx(direction*-1);
        }

        public boolean isRotateRightIdx(int value){
            return state[getRightIndex()]+value==1;
        }

        public boolean isRotateLeftIdx(int value){
            return state[getLeftIndex()]+value==1;
        }

        private Integer getLeftIndex() {
            return cacIdx(-2);
        }

        private Integer getRightIndex() {
            return cacIdx(2);
        }

        private Integer cacIdx(int alpha) {
            return (twelveIndex+alpha+8)%8;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Gear> a = new ArrayList<>();
        for(int i=0;i<4;i++){
            String s = in.readLine();
            int[] state = new int[8];
            for(int j=0;j<8;j++){
                state[j]=Integer.parseInt(Character.toString(s.charAt(j)));
            }
            Gear gear = new Gear(state);
            if(i!=0){
                gear.addLeft(a.get(i-1));
            }
            a.add(gear);
        }

        int n = Integer.parseInt(in.readLine());
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int target=Integer.parseInt(st.nextToken());
            int direction=Integer.parseInt(st.nextToken());
            a.get(target-1).rotation(direction);
        }

        int result=0;
        for(int i=0;i<4;i++){
            Gear gear = a.get(i);
            if(gear.state[gear.twelveIndex]==1){
                result+=(1<<i);
            }
        }

        System.out.println(result);
    }
}
