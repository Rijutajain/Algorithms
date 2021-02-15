import java.util.*;

public class FibonacciSumSquares {
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
    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;
     int rem=(int)(n%60);
     long f1=calc_fib(rem);
     long f2=calc_fib(rem+1);
     long sum=f1*f2;

        return sum % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquaresNaive(n);
        System.out.println(s);
    }
}

