import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class HashSubstring {
    private static long d;
    private static long h;
    private static int patLength;
    private static int textLength;
    private static long pHash;
    private static long windowHash;
    private static List<Integer> occurrences;
    private static long q=1000000000+7;

    private static FastScanner in;
    private static PrintWriter out;

    public static void main(String[] args) throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        printOccurrences(getOccurrences(readInput()));
        out.close();
    }

    private static Data readInput() throws IOException {
        String pattern = in.next();
        String text = in.next();
        return new Data(pattern, text);
    }

    private static void printOccurrences(List<Integer> ans) throws IOException {
        for (Integer cur : ans) {
            out.print(cur);
            out.print(" ");
        }
    }

    private static List<Integer> getOccurrences(Data input) {
        /*String s = input.pattern, t = input.text;
        int m = s.length(), n = t.length();
        List<Integer> occurrences = new ArrayList<Integer>();
        for (int i = 0; i + m <= n; ++i) {
	    boolean equal = true;
	    for (int j = 0; j < m; ++j) {
		if (s.charAt(j) != t.charAt(i + j)) {
		     equal = false;
 		    break;
		}
	    }
            if (equal)
                occurrences.add(i);
	}
        return occurrences;*/
        List<Integer> occurrences = new ArrayList<Integer>();
        d=256;
        h=1;
        pHash=0;
        windowHash=0;
        int f=0;
        patLength=input.pattern.length();
        textLength=input.text.length();
        for(int i=0;i<patLength-1;i++){
           h=(d*h)%q;
        }
        for(int j=0;j<patLength;j++){
            pHash=(d*pHash+input.pattern.charAt(j))%q;
            windowHash=(d*windowHash+input.text.charAt(j))%q;
        }
        for(int k=0;k<=textLength-patLength;k++){
            if(pHash==windowHash){
                for(f=0;f<patLength;f++){
                    if(input.text.charAt(k+f)!=input.pattern.charAt(f)){
                        break;
                    }
                }
                if(f==patLength){
                    occurrences.add(k);
                }
                
            }
            //long k1=(d*(windowHash - input.text.charAt(k)*h)%q);
            //long k2= input.text.charAt(k+patLength)%q;
            if(k<textLength-patLength){
                //windowHash=k1+k2;
                windowHash = (d*(windowHash - input.text.charAt(k)*h) + input.text.charAt(k+patLength))%q; 
                if(windowHash<0){
                    windowHash=windowHash+q;
                }
            }
           
        }
         return occurrences;
       
    }

    static class Data {
        String pattern;
        String text;
        public Data(String pattern, String text) {
            this.pattern = pattern;
            this.text = text;
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

