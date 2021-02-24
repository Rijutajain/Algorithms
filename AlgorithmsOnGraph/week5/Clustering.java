import java.util.Scanner;
import java.util.*;

    class Edges implements Comparable<Edges>{
        public int source;
        public int destination;
        public double distance;
        public Edges(int source,int destination,double distance){
            this.source=source;
            this.destination=destination;
            this.distance=distance;
        }
        public int compareTo(Edges that){
            if(this.distance>that.distance){
                return 1;
            }
            else{
                return -1;
            }
        }
    }
    class Coordinates{
        public int absicca;
        public int ordinate;
        public Coordinates(int x,int y){
            absicca=x;
            ordinate=y;
        }
    }

public class Clustering {
      private static ArrayList<Coordinates> adjco;
      private static ArrayList<Edges> adj;
       private static boolean[] visited;
    private static ArrayList<Coordinates> storingCoordinates(int[] x,int[] y){
        adjco=new ArrayList<Coordinates>();
        for(int i=0;i<x.length;i++){
            adjco.add(new Coordinates(x[i],y[i]));
        }
        return adjco;
    }
    private static double computingDistance(int u1,int v1,int u2,int v2){
        double p=(u1-u2)*(u1-u2);
        double q=(v1-v2)*(v1-v2);
        double dist=Math.pow(p+q,0.5);
        return dist;
    }
    private static ArrayList<Edges> makingGraph(ArrayList<Coordinates> adjco){
        adj=new ArrayList<Edges>();
        for(int i=0;i<adjco.size();i++){
           for(int j=i+1;j<adjco.size();j++){
              double dist=computingDistance(adjco.get(i).absicca,adjco.get(i).ordinate,adjco.get(j).absicca,adjco.get(j).ordinate);
              adj.add(new Edges(i,j,dist));

           }
      }
      return adj;
      
    }
    private static double clustering(int[] x, int[] y, int k) {
        double d=0.000000000;
         ArrayList<Coordinates> adjco=storingCoordinates(x,y);
        ArrayList<Edges> adj=makingGraph(adjco);
        Collections.sort(adj);
        int graphEdges=adj.size();
        int vertex=x.length;
        int treeEdges=vertex-1;
        ArrayList<Edges> tree=new ArrayList<Edges>();
        int p=0;
        int[] parent=new int[vertex];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
        for(int i=0;i<graphEdges;i++){
            /*if(tree.size() == treeEdges-(k-1)){
                break;
            }*/
            Edges currEdge=adj.get(i);
            int sourceParent=find(currEdge.source,parent);
            int destinationParent=find(currEdge.destination,parent);
            if(sourceParent != destinationParent){
               tree.add(currEdge);
               parent[sourceParent]=parent[destinationParent];
            }
        }
        Collections.sort(tree);
        Collections.reverse(tree);
        return tree.get(k-2).distance;
    }
    private static int find(int v,int[] parent){
        if(parent[v]==v){
            return v;
        }
        return find(parent[v],parent);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        System.out.println(clustering(x, y, k));
    }
}

