import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    /*private static int[] sort(int from,int to,int[] values,int[] weights){
      int[] knap=new int[values.length];
      for(int i=0;i<knap.length;i++){
        knap[i]=values[i]/weights[i];
      }
      return Arrays.sort(knap);

    }*/
    static class MyComparator implements Comparator<knapEntry> {
        public int compare(knapEntry obj1,knapEntry obj2){
           if(obj1.vw<obj2.vw)
            return 1;
           if(obj1.vw==obj2.vw)
            return 0;
           else
            return -1;
        }
    }
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
       
        knapEntry[] knap=new knapEntry[values.length];
        for(int i=0;i<weights.length;i++){
         knap[i]=new knapEntry(weights[i],(double)(values[i])/weights[i]);
         }
        
      
       MyComparator mm=new MyComparator();

         Arrays.sort(knap,mm);
        for(int i=0;i<knap.length;i++){
            if(capacity==0){
                return value;
            }
            int a=min(knap[i].weight,capacity);
            //double vw=(double)(values[i])/weights[i];
            double vw=knap[i].vw;
            value=value+a*vw;
            knap[i].vw=knap[i].vw+a;
            capacity=capacity-a;
        }

        return value;
    }
    private static int min(int v1,int v2){
        if(v1<v2){
            return v1;
        }
        else{
            return v2;
        }
    } 

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }

    static class knapEntry{
        int weight;
        double vw;
    public knapEntry(int wt,double ratio){
        weight=wt;
        vw=ratio;
    }
}
}
