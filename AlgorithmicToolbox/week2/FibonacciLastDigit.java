import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        int[] fi=new int[n+1];
    fi[0]=0;
    fi[1]=1;
    for(int i=2;i<=n;i++){
      fi[i]=(fi[i-1]+fi[i-2])%10;

    }
    return fi[n];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}

