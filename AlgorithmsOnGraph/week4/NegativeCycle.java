import java.util.ArrayList;
import java.util.Scanner;
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
public class NegativeCycle {
    private static long[] distance;
    private static int negativeCycle(ArrayList<Edge> edge,ArrayList<Integer>[] adj, ArrayList<Integer>[] cost) {
        int numberEdges=edge.size();
        int vertex=adj.length;
        distance=new long[vertex];
        for(int i=0;i<vertex;i++){
            distance[i]=10000000000L;
        }
        distance[0]=0;
        for(int i=0;i<vertex-1;i++){
            boolean isUpdated=false;
            for(int j=0;j<numberEdges;j++){
                 int u=edge.get(j).source;
                 int v=edge.get(j).destination;
                 int wt=edge.get(j).weight;
                 if(distance[u]+wt<distance[v]){
                    distance[v]=distance[u]+wt;
                    isUpdated=true;
                 }

            }
           /* if(isUpdated==false){
                return 0;
            }*/
        }
        for(int i=0;i<numberEdges;i++){
                 int u=edge.get(i).source;
                 int v=edge.get(i).destination;
                 int wt=edge.get(i).weight;
                 if(distance[u]+wt<distance[v]){
                    return 1;
                 }
        }
        return 0;
      
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
        System.out.println(negativeCycle(edge,adj, cost));
    }
}

