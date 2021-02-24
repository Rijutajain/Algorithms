import java.util.Scanner;
import java.util.*;

    class Neighbours implements Comparable<Neighbours>{
        public int targetNode;
        public double distanceFromNode;
        public Neighbours(int targetNode,double distanceFromNode){
            this.targetNode=targetNode;
            this.distanceFromNode=distanceFromNode;
        }
        public int compareTo(Neighbours that){
            if(this.distanceFromNode>that.distanceFromNode){
                return 1;
            }
            else{
                return -1;
            }
        }
    }
    class Edges{
        public int source;
        public int destination;
        public double distance;
        public Edges(int source,int destination,double distance){
            this.source=source;
            this.destination=destination;
            this.distance=distance;
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
public class ConnectingPoints {
      private static ArrayList<Coordinates> adjco;
      private static ArrayList<Edges> adj;
       private static ArrayList<Neighbours>[] neighbourList;
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
    public static ArrayList<Neighbours>[] neighbourList(ArrayList<Edges> adj,int[] x){
        neighbourList = (ArrayList<Neighbours>[])new ArrayList[x.length];
          for (int i = 0; i < neighbourList.length; i++) {
            neighbourList[i] = new ArrayList<Neighbours>();
        }
        for(int i=0;i<adj.size();i++){
            
                int temp=adj.get(i).source;
                neighbourList[temp].add(new Neighbours(adj.get(i).destination,adj.get(i).distance));
                 temp=adj.get(i).destination;
                neighbourList[temp].add(new Neighbours(adj.get(i).source,adj.get(i).distance));
            
        }
        return neighbourList;

    }  
    private static double minimumDistance(int[] x, int[] y) {
        ArrayList<Coordinates> adjco=storingCoordinates(x,y);
        ArrayList<Edges> adj=makingGraph(adjco);
        ArrayList<Neighbours>[] neighbourList=neighbourList(adj,x);
        double result = 0.0000000;
         visited=new boolean[x.length];
        for(int i=0;i<visited.length;i++){
            visited[i]=false;
        }
         PriorityQueue<Neighbours> minHeap=new PriorityQueue<>();
         minHeap.add(new Neighbours(0,0));
        while(!minHeap.isEmpty()){
            Neighbours p=minHeap.poll();
            int v=p.targetNode;
            if(visited[v]==true){
                continue;
            }
            visited[v]=true;
            result=result+p.distanceFromNode;
            ArrayList<Neighbours> children=neighbourList[v];
            for(Neighbours n : children){
                  if(!visited[n.targetNode]){
                    minHeap.add(n);
                  }
            }
        }
        return result;
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
        System.out.println(minimumDistance(x, y));
    }
}

