import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b,int m,int n) {
        int L[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
        if(i==0 || j==0){
            L[i][j]=0;
        }
        else if(a[i-1]==b[j-1]){
          L[i][j]= 1+L[i-1][j-1];
        }
        else{
            L[i][j] = max(L[i-1][j], L[i][j-1]); 
        }
     }
   }
   return L[m][n];
}
    public static int max(int n1,int n2){
        if(n1>=n2){
            return n1;
        }
        else{
            return n2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b,a.length,b.length));
    }
}

