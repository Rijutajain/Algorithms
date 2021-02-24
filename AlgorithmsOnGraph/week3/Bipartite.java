import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.*;

public class Bipartite {
    private static int[] colours;
    private static int bipartite(ArrayList<Integer>[] adj) {
        colours=new int[adj.length];
        for(int i=0;i<colours.length;i++){
            colours[i]=0;
        }
        for(int i=0;i<adj.length;i++){
            if(colours[i]==1 || colours[i]==-1){
                continue;
            }
            Queue <Integer> queue=new LinkedList<>();
            queue.add(i);
            colours[i]=1;
            while(!queue.isEmpty()){
                Integer node=queue.poll();
                ArrayList<Integer> childrenList=adj[node];
                for(Integer child : childrenList){
                    if(colours[child]==0){
                        colours[child] = -colours[node];
                        queue.add(child);
                    }
                    if(colours[child]==colours[node]){
                        return 0;
                    }
                }
            }

        }
        //write your code here
        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(bipartite(adj));
    }
}

