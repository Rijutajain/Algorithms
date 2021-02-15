import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        int left1=getMajorityElement(a,left,(left+right)/2);
        int right1=getMajorityElement(a,(left+right)/2,right);
        if(left1==right1){
            return left1;
        }
        else{
            if(isMajorityElement(a,left1,left,right)==true){
                return left1;
            }
            else if(isMajorityElement(a,right1,left,right)==true){
                return right1;
            }
            else{
                return -1;
            }
        }

    }
    private static boolean isMajorityElement(int[] a,int number,int left,int right){
        int count=0;
        for(int i=left;i<right;i++){
            if(a[i]==number){
                count=count+1;
            }
        }
        if(count>(right-left)/2){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

