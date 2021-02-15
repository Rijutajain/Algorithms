import java.util.*;

public class FibonacciSumLastDigit {
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
   
    private static long getFibonacciSumNaive(long n) {
         int rem=(int)(n%60);
        long j=calc_fib(rem+2);
            long sum=((j)%10+9)%10;
            return sum;

    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
    }
}

