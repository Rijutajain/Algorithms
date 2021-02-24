import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.*;

public class StronglyConnected {
    private static ArrayList<Integer>[] transpose;
    private static boolean[] visited;
    private static Stack<Integer> myStack=new Stack<>();
    /*private static void DFS1(ArrayList<Integer>[] adj,int x){
       
         Stack<Integer> stack=new Stack<>();
        stack.push(x);
        //myStack.push(x);
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
             myStack.push(node);
        }
    }*/
     private static void DFS1(ArrayList<Integer>[] adj,int x){       
        visited[x]=true;
        ArrayList<Integer> neighbourList=adj[x];
        for(Integer neighbour:neighbourList){
            if(!visited[neighbour]){
                DFS1(adj, neighbour);                
            }
        }
        myStack.push(x);        
    }

    private static void reverse(ArrayList<Integer>[] adj,ArrayList<Integer>[] transpose){
        
           for (int i = 0; i < transpose.length; i++) {
            transpose[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<adj.length;i++){
            for(int j=0;j<adj[i].size();j++){
                  transpose[adj[i].get(j)].add(i);
            }
        }
    }
    private static void DFS2(ArrayList<Integer>[] transpose,int x){
        
            Stack<Integer> stack=new Stack<>();
        stack.push(x);
        visited[x]=true;
        while(!stack.isEmpty()){
            Integer node=stack.pop();
            ArrayList<Integer> neighbourList=transpose[node];
            for(Integer neighbour:neighbourList){
                if(!visited[neighbour]){
                    stack.push(neighbour);
                    visited[neighbour]=true;
                }
            }
        }

    }
    private static int numberOfStronglyConnectedComponents(ArrayList<Integer>[] adj) {
        int result=0;
          visited=new boolean[adj.length];
         for(int i=0;i<visited.length;i++){
            visited[i]=false;
        }
        //write your code here
          for(int i=0;i<adj.length;i++){
            if(!visited[i]){
                DFS1(adj,i);
            }
        }
         transpose=(ArrayList<Integer>[])new ArrayList[adj.length];
        reverse(adj,transpose);
         for(int i=0;i<visited.length;i++){
            visited[i]=false;
        }
        while(!myStack.isEmpty()){
            Integer node=myStack.pop();
            if(!visited[node]){
            DFS2(transpose,node);
            result++;
           }
        }
        
        return result;
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
        }
        System.out.println(numberOfStronglyConnectedComponents(adj));
    }
}

