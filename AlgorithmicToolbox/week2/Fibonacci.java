import java.util.Scanner;

public class Fibonacci {
   private static long calc_fib(int n) {
    if(n==0){
     return 0;
     }
     else{
    long[] fi=new long[n+1];
    fi[0]=0;
    fi[1]=1;
    for(int i=2;i<=n;i++){
      fi[i]=fi[i-1]+fi[i-2];

    }
    return fi[n];
  }
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
