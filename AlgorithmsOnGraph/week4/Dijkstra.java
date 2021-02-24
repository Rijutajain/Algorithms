import java.util.*;

    class Edge implements Comparable<Edge>{
        public int targetNode;
        private  long distanceFromNode;
        public Edge(int targetNode,long distanceFromNode){
            this.targetNode=targetNode;
            this.distanceFromNode=distanceFromNode;
        }
        public int compareTo(Edge that){
            if(this.distanceFromNode>that.distanceFromNode){
                return 1;
            }
            else{
                return -1;
            }
        }
    }
public class Dijkstra {
    private static boolean[] visited;
    private static long[] distance;
    private static long distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        visited=new boolean[adj.length];
        for(int i=0;i<visited.length;i++){
            visited[i]=false;
        }
        distance=new long[visited.length];
        for(int i=0;i<distance.length;i++){
            distance[i]=Long.MAX_VALUE;
        }
        if(s==t){
            return 0;
        }
        PriorityQueue<Edge> minHeap=new PriorityQueue<>();
        distance[s]=0;
        minHeap.add(new Edge(s,0));
        while(!minHeap.isEmpty()){
            int v=minHeap.poll().targetNode;
             if(v==t){
             return distance[v];
            }
            if(visited[v]==true){
                continue;
            }
            visited[v]=true;
            ArrayList<Integer> children=adj[v];
            for(int i=0;i<children.size();i++){
                  int child=children.get(i);
                  int dist=cost[v].get(i);
                  if(!visited[child] && (distance[v]+dist<distance[child])){
                    distance[child]=distance[v]+dist;
                    Edge ee=new Edge(child,distance[child]);
                    minHeap.add(ee);
                    //visited[child]=true;
                   
                  }
            }

        }
        if(distance[t]==Long.MAX_VALUE){
            return -1;
        }
        return distance[t];
    }
  
    /*public static void printEdgeList(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost){
        for(int i=0;i<adj.length;i++){
            for(int j=0;j<adj[i].size();j++){
                 System.out.println(i + adj[i].get(j)+cost[i].get(j));
            }
        }
    }*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
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
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}

