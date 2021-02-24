import java.util.*;
 class Edge {
        public int source;
        public  int destination;
        public int weight;

        public Edge(int source,int destination,int weight){
            this.source=source;
            this.destination=destination;
            this.weight=weight;
        }
    }
public class ShortestPaths {
    private static boolean[] visited;
    private static ArrayList<Integer> negativeCycle;
    private static void shortestPaths( ArrayList<Integer>[] adj,ArrayList<Edge> edge, int s,int[] reachable,int[] shortest,long[] distance) {
        int numberEdges=edge.size();
        int vertex=adj.length;
        distance[s]=0;
        for(int i=0;i<vertex-1;i++){
            for(int j=0;j<numberEdges;j++){
                 int u=edge.get(j).source;
                 int v=edge.get(j).destination;
                 int wt=edge.get(j).weight;
                 if(distance[u]!=Long.MAX_VALUE && distance[u]+wt<distance[v]){
                    distance[v]=distance[u]+wt;
                 }

            }
        }
        negativeCycle=new ArrayList<Integer>();
        for(int i=0;i<numberEdges;i++){
                 int u=edge.get(i).source;
                 int v=edge.get(i).destination;
                 int wt=edge.get(i).weight;
                 if(distance[u]!=Long.MAX_VALUE && distance[u]+wt<distance[v]){
                    negativeCycle.add(v);
                    shortest[v]=0;
                 }
        }
        elementsNegativeCycle(negativeCycle,adj,shortest);
        for(int i=0;i<distance.length;i++){
            if(distance[i]==Long.MAX_VALUE){
                reachable[i]=1;
            }
        }
        
    
    }
    private static void elementsNegativeCycle(ArrayList<Integer> negativeCycle,ArrayList<Integer>[] adj,int[] shortest){
        for(int i=0;i<negativeCycle.size();i++){
            DFS(adj,negativeCycle.get(i));
            for(int j=0;j<visited.length;j++){
                if(visited[j]==true){
                    shortest[j]=0;
                }
            }
        }
    }
     private static void DFS(ArrayList<Integer>[] adj,int x){
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
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
          ArrayList<Edge> edge=new ArrayList<Edge>();
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
             Edge ee=new Edge(x-1,y-1,w);
            edge.add(ee);
        }
        int s = scanner.nextInt() - 1;
        long distance[] = new long[n];
        int reachable[] = new int[n];
        int shortest[] = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = Long.MAX_VALUE;
            reachable[i] = 0;
            shortest[i] = 1;
        }
        shortestPaths(adj, edge, s, reachable, shortest, distance);
        for (int i = 0; i < n; i++) {
            if (reachable[i]==1) {
                System.out.println('*');
            } else if (shortest[i] == 0) {
                System.out.println('-');
            } else {
                System.out.println(distance[i]);
            }
        }
    }

}

