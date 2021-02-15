import java.util.*;

public class PrimitiveCalculator {
    
   private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
          int[] auxillary=new int[n+1];
          int[] real=new int[n+1];
        
        int n1=0;
        int n2=0;
        int n3=0;
        real[0]=Integer.MAX_VALUE;
        real[1]=0;
         for(int i=2;i<n+1;i++){
           if(i%3==0){
             n1=i/3;
           }
           else{
            n1=0;
           }
           if(i%2==0){
            n2=i/2;
           }
           else{
            n2=0;
           }
           n3=i-1;
           twoValues y=min(real,n1,n2,n3);
          // int temp=min(real[n1],real[n2],real[n3]);
        //int index=0;
        //if(temp==real[n1]){
         //   index=n1;
        //}
        //else if(temp==real[n2]){
        //    index=n2;
        //}
        // else{
        //    index=n3;
        //}
         real[i]=1+y.minimum;
        auxillary[i]=y.index;
         }
        sequence.add(n);
         int x=n; 
        while(auxillary[x]>=1){
        sequence.add(auxillary[x]);
        x=auxillary[x];
       }
        
     Collections.reverse(sequence);
        return sequence;
    }
    public static twoValues min(int[] a,int n1,int n2,int n3){
          if(a[n1]<=a[n2] && a[n1]<=a[n3]){
            return new twoValues(a[n1],n1);
          }
          if(a[n2]<=a[n3] && a[n2]<=a[n1]){
            return  new twoValues(a[n2],n2);
          }
          if(a[n3]<=a[n1] && a[n3]<=a[n2]){
            return new twoValues(a[n3],n3);
          }
          return null;
    }
    private static class twoValues{
        int minimum;
        int index;
        twoValues(int min,int idx){
            this.minimum=min;
            this.index=idx;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

