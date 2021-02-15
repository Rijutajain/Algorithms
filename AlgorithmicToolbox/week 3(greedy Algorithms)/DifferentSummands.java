import java.util.*;
import java.util.Arrays;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
         if(n==1 || n==2){
            summands.add(n);
            return summands;
        }

        for(int i=1;i<=n;i++){
            int r=n-(i*(i+1))/2;
            if(r==0){
                 for(int k=1;k<=i;k++){
                    summands.add(k);
                 }
                 break;
            }
            else if(r<=i){
                 for(int k=1;k<i;k++){
                    summands.add(k);
                }
                    summands.add(i+r);
                    
                 break;
            }
            
        }
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

