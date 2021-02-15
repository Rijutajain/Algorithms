import java.util.*;

public class GCD {
  private static int EuclidGCD(int a, int b) {
   if(b==0){
       return a;
    }
    int ar=a%b;
    return EuclidGCD(b,ar);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(EuclidGCD(a, b));
  }
}
