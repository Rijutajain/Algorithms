import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.*;

public class BFS {
    private static boolean[] visited;
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
        //write your code here
        visited=new boolean[adj.length];
        if(s==t){
            return 0;
        }
        Queue<Integer> queue=new LinkedList<>();
        int distance=0;
        queue.add(s);
        visited[s]=true;
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size>0){
                Integer node=queue.poll();
                List<Integer> childrenList=adj[node];
                for(Integer child : childrenList){
                    if(child==t){
                        int d=distance+1;
                        return d;
                    }
                    if(!visited[child]){
                        queue.add(child);
                        visited[child]=true;
                    }
                }
                size--;
            }
            distance++;
        }

        return -1;
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, x, y));
    }
}

