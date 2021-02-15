import java.util.*;

public class LCM {
   private static int EuclidGCD(int a, int b) {
   if(b==0){
       return a;
    }
    int ar=a%b;
    return EuclidGCD(b,ar);
  }

  private static long lcm_naive(int a, int b) {
  int gcd=EuclidGCD(a,b);
    long a1=a;
    long b1=b;
    long lcm=a1*b1/gcd;
    return lcm;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_naive(a, b));
  }
}
