import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class JobQueue {
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;
    private PriorityQueue<Some> p;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }
 
     

    private void assignJobs() {
        // TODO: replace this code with a faster algorithm.
       /* assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];
        long[] nextFreeTime = new long[numWorkers];
        for (int i = 0; i < jobs.length; i++) {
            int duration = jobs[i];
            int bestWorker = 0;
            for (int j = 0; j < numWorkers; ++j) {
                if (nextFreeTime[j] < nextFreeTime[bestWorker])
                    bestWorker = j;
            }
            assignedWorker[i] = bestWorker;
            startTime[i] = nextFreeTime[bestWorker];
            nextFreeTime[bestWorker] += duration;
        }*/
        assignedWorker=new int[jobs.length];
         startTime = new long[jobs.length];
         p=new PriorityQueue<Some>(numWorkers);
         int x=Math.min(numWorkers,jobs.length);
         
        for(int i=0;i<x;i++){
            int m=jobs[i];
            Some s1=new Some((long)m,i);
            p.add(s1);
            startTime[i]=0;
            assignedWorker[i]=i;
        }
         for(int k=numWorkers;k<jobs.length;k++){
              Some j=p.poll();
              startTime[k]=j.duration;
              long n=j.duration+(long)jobs[k];
              Some s2=new Some(n,j.worker);
              p.add(s2);
              assignedWorker[k]=j.worker;


         }
    }
     static class Some implements Comparable<Some>{
        long duration;
        int worker;
        public Some(long t,int w){
            duration=t;
            worker=w;
        }
        //return 0 if duration of this and that is equal
        //return -1 if duration of this > that
        //return 1 if duration of that>this
        public int compareTo(Some that){
             if(this.duration==that.duration){
                if(this.worker<that.worker){
                    return -1;
                }
                else{
                    return 1;
                }
             }
             else if(this .duration<that.duration){
                return -1;
             }
             else{
                return 1;
             }
        }

     }
    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
