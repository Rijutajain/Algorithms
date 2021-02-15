import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class HashChains {

    private FastScanner in;
    private PrintWriter out;
    // store all strings in one list
    private List<String> elems;
    // for hash function
    private int bucketCount;
    private int prime = 1000000007;
    private int multiplier = 263;
   // ArrayList<String>[] arrayOfList;
    ListOfString[] arrayOfList;
    

    public static void main(String[] args) throws IOException {
        new HashChains().processQueries();
    }

    private int hashFunc(String s) {
        long hash = 0;
        for (int i = s.length() - 1; i >= 0; --i)
            hash = (hash * multiplier + s.charAt(i)) % prime;
        return (int)hash % bucketCount;
    }

    private Query readQuery() throws IOException {
        String type = in.next();
        if (!type.equals("check")) {
            String s = in.next();
            return new Query(type, s);
        } else {
            int ind = in.nextInt();
            return new Query(type, ind);
        }
    }

    private void writeSearchResult(boolean wasFound) {
        out.println(wasFound ? "yes" : "no");
        // Uncomment the following if you want to play with the program interactively.
        // out.flush();
    }

    private void processQuery(Query query) {
       // ArrayList<String>[] arrayOfList=new ArrayList<String>[bucketCount];
        
        switch (query.type) {
            case "add":
                /*if (!elems.contains(query.s))
                    elems.add(0, query.s);
                break;*/
                int k=hashFunc(query.s);
                if(arrayOfList[k].elements.contains(query.s)){
                    return;
                }
                
                arrayOfList[k].elements.add(0,query.s);
                    break;
                
            case "del":
               /* if (elems.contains(query.s))
                    elems.remove(query.s);
                break;*/
                 int l=hashFunc(query.s);
                if(!arrayOfList[l].elements.contains(query.s)){
                    return;
                }
                 arrayOfList[l].elements.remove(query.s);
                break;

            case "find":
                /*writeSearchResult(elems.contains(query.s));
                break;*/
                int p=hashFunc(query.s);
                writeSearchResult(arrayOfList[p].elements.contains(query.s));
                   break; 
            case "check":
               /* for (String cur : elems)
                    if (hashFunc(cur) == query.ind)
                        out.print(cur + " ");
                out.println();
                // Uncomment the following if you want to play with the program interactively.
                // out.flush();
                break;*/
                if(arrayOfList[query.ind].elements.size()==0){
                    out.println(" ");
                }
                else{
                for(int i=0;i<arrayOfList[query.ind].elements.size();i++){
                     out.print(arrayOfList[query.ind].elements.get(i)+" ");

                }
                 out.println();
              }
              break;
            default:
                throw new RuntimeException("Unknown query: " + query.type);
        }
    }

    public void processQueries() throws IOException {

        elems = new ArrayList<>();
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        bucketCount = in.nextInt();
         arrayOfList=new ListOfString[bucketCount];
         for(int i=0;i<bucketCount;i++){
            arrayOfList[i]=new ListOfString();
         }
        int queryCount = in.nextInt();
        for (int i = 0; i < queryCount; ++i) {
            processQuery(readQuery());
        }
        out.close();
    }

    static class Query {
        String type;
        String s;
        int ind;

        public Query(String type, String s) {
            this.type = type;
            this.s = s;
        }

        public Query(String type, int ind) {
            this.type = type;
            this.ind = ind;
        }
    }
    static class ListOfString{
        ArrayList<String> elements;
        public ListOfString(){
            this.elements=new ArrayList<String>();
        }
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
