import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c,int j,int k,int l ) {
        int L[][][]=new int[j+1][k+1][l+1];
        for (int m=0; m<=j; m++) 
        { 
            for (int n=0; n<=k; n++) 
            { 
                for (int o=0; o<=l; o++) 
                { 
                    if (m == 0 || n == 0 || o==0) {
                        L[m][n][o] = 0; 
                    }
                    else if(a[m-1]==b[n-1] && b[n-1]==c[o-1]){
                      L[m][n][o]=1+L[m-1][n-1][o-1];
                    }
                    else{
                        L[m][n][o]=max(L[m-1][n][o],L[m][n-1][o],L[m][n][o-1]);
                    }
                }
            }
        }

        return L[j][k][l];
    }
     public static int max(int n1,int n2,int n3){
        if(n1>=n2 && n1>=n3){
            return n1;
        }
        else if(n2>=n1 && n2>=n3){

            return n2;
        }
        else{
            return n3;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c,a.length,b.length,c.length));
    }
}

