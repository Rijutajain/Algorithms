import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int[] stops1=new int[stops.length+2];
        stops1[0]=0;
        stops1[stops.length+1]=dist;
        for(int i=0;i<stops.length;i++){
            int k=stops[i];
            stops1[i+1]=k;
        }
        int lastRefill=0;
        int currentRefill=0;
        int numRefills=0;
        while(currentRefill<stops1.length-1){
          lastRefill=currentRefill;
          while(currentRefill<stops1.length-1 && stops1[currentRefill+1]-stops1[lastRefill]<=tank){
            
           currentRefill=currentRefill+1;
          }
          if (currentRefill==lastRefill){
            return -1;
          }
         if(currentRefill<stops1.length-1){
         numRefills=numRefills+1;
         }
        }
        return numRefills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
