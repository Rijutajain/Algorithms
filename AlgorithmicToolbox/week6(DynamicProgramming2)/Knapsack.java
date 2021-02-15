import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        int n=w.length;
        int [][] G=new int[n+1][W+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){
                if(i==0 || j==0){
                    G[i][j]=0;
                }
                else if(w[i-1]<=j){
                   G[i][j]=max(w[i-1]+G[i-1][j-w[i-1]],G[i-1][j]);
                }
                
                else{
                    G[i][j]=G[i-1][j];
                }
            }
        }
       /* int result = 0;
        for (int i = 0; i < w.length; i++) {
          if (result + w[i] <= W) {
            result += w[i];
          }
        }
        return result;*/
        return G[n][W];
    }
    public static int max(int n1,int n2){
        if(n1>n2)
            return n1;
        else
            return n2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

