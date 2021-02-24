import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.HashMap;
import java.util.*;
import java.util.Map;

public class Toposort {
    private static HashMap<Integer,Integer> incomingDegree;
    private static Queue<Integer> sourceQueue;
    private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
        incomingDegree=new HashMap<Integer,Integer>();
        sourceQueue=new LinkedList<Integer>();
        for(int i=0;i<adj.length;i++){
            incomingDegree.put(i,0);
        }
        for(int i=0;i<adj.length;i++){
            for(int j=0;j<adj[i].size();j++){
                int k=adj[i].get(j);
                incomingDegree.put(k,incomingDegree.get(k)+1);
            }
        }
        ArrayList<Integer> result=topologicalSort(adj);
        //write your code here
        return result;
    }

    private static ArrayList<Integer> topologicalSort(ArrayList<Integer>[] adj) {
         ArrayList<Integer> result=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : incomingDegree.entrySet()){
            if(entry.getValue()==0){
                sourceQueue.add(entry.getKey());
            }
        }
      //write your code here
       
        while(!sourceQueue.isEmpty()){
            int source=sourceQueue.remove();
            result.add(source);
            ArrayList<Integer> childrenList=adj[source];
            for(Integer children : childrenList){
                incomingDegree.put(children,incomingDegree.get(children)-1);
                if(incomingDegree.get(children)==0){
                    sourceQueue.add(children);
                }
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
        ArrayList<Integer> order = toposort(adj);
        for (int x : order) {
            System.out.print((x + 1) + " ");
        }
    }
}

