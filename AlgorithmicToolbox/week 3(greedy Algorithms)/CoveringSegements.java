import java.util.*;
import java.util.List; 
import java.util.ArrayList;
import java.util.Arrays;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        ArrayList<Segment> seg=new ArrayList<Segment>(Arrays.asList(segments));
        ArrayList<Integer> pointsList=new ArrayList<Integer>();
        while(seg.size()>0){//O(n)
            int min=seg.get(0).end;
          for(int i=0;i<seg.size();i++){//O(n)
            if(seg.get(i).end<min){
                min=seg.get(i).end;
            }
        }
        
        pointsList.add(min);
        //Segment ss=new Segment(str,end);
        for(int i=0;i<seg.size();i++){//O(n)
            Segment s=seg.get(i);
            if(s.contains(min)==true){
                seg.remove(s);
                i--;
            }
        }
        
    }
    int[] points = new int[pointsList.size()]; 
        for(int i=0;i<pointsList.size();i++){//O(n)
            points[i]=pointsList.get(i);
        }
        return points;
    }
    
    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
        private boolean contains(int point){
            if(point>=start && point<=end){
                return true;
            }
            else{
                return false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}

