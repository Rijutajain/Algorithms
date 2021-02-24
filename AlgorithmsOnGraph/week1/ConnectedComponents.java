import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class ConnectedComponents {
    private static boolean[] visited;
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        visited=new boolean[adj.length];
         for(int i=0;i<visited.length;i++){
            visited[i]=false;
        }
        int result = 0;
        //write your code here
        for(int i=0;i<adj.length;i++){
            if(!visited[i]){
                DFS(adj,i);
                result++;
            }
        }
        return result;
    }
     private static void DFS(ArrayList<Integer>[] adj,int x){
       
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
        System.out.println(numberOfComponents(adj));
    }
}

