import java.util.*;

public class FibonacciPartialSum {
      private static long calc_fib(int n){
     if(n==0){
     return 0;
     }
     else{
    long[] fi=new long[n+1];
    fi[0]=0;
    fi[1]=1;
    for(int i=2;i<=n;i++){
      fi[i]=(fi[i-1]+fi[i-2])%10;

    }
    return fi[n];
  }
  }
    private static long getFibonacciPartialSumNaive(long from, long to) {
         int rem1=(int)(from%60);
        long j1=calc_fib(rem1+2);
        long sum1=((j1)%10+9)%10;
        //long sum1=j1-1;
         int rem2=(int)(to%60);
        long j2=calc_fib(rem2+2);
           long sum2=((j2)%10+9)%10;
         //long sum2=j2-1;
            int rr=(int)(from%60);
           long jj=calc_fib(rr);
        long s= (sum2-sum1+jj)%10;
        
        return s;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }
}

