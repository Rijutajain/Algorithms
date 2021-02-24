import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Reachability {
    private static boolean[] visited;
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        //write your code here
        DFS(adj,x,y);
        if(visited[y]==true){
            return 1;
        }

        else{
        return 0;
       }
    }
    private static void DFS(ArrayList<Integer>[] adj,int x,int y){
         visited=new boolean[adj.length];
         for(int i=0;i<visited.length;i++){
            visited[i]=false;
        }
        Stack<Integer> stack=new Stack<>();
        stack.push(x);
        visited[x]=true;
        while(!stack.isEmpty()){
            Integer node=stack.pop();
            ArrayList<Integer> neighbourList=adj[node];
            for(Integer neighbour:neighbourList){
                if(!visited[neighbour]){
                    stack.push(neighbour);
                    visited[neighbour]=true;
                    if(neighbour==y){
                        return;
                    }
                }
            }
        }
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
        System.out.println(reach(adj, x, y));
    }
}

