import java.util.*;
import java.io.*;

public class is_bst_hard {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public class IsBST {
        class Node {
            int key;
            int left;
            int right;

            Node(int key, int left, int right) {
                this.left = left;
                this.right = right;
                this.key = key;
            }
        }

        int nodes;
        Node[] tree;

       void read() throws IOException {
            FastScanner in = new FastScanner();
            nodes = in.nextInt();
            tree = new Node[nodes];
            for (int i = 0; i < nodes; i++) {
                tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());

            }
        }

        boolean isBinarySearchTreeWrapper() {
          // Implement correct algorithm here
            if(tree.length==0){
                return true;
            }
            Node root=tree[0];
           
          return isBinarySearchTree(root,Long.MIN_VALUE,Long.MAX_VALUE);
        }
         boolean isBinarySearchTree(Node n,long min,long max){
            boolean ans1=true;
            boolean ans2=true;
            long l=n.key;
            if(n==null){
                return true;
            }
            if(l<min || l>max){
                return false;
            }
            if(n.left!=-1){
             ans1=isBinarySearchTree(tree[n.left],min,l-1);
            }
            if(n.right!=-1){
             ans2=isBinarySearchTree(tree[n.right],l,max);
            }
            return ans1 && ans2;
        }
    }
    

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new is_bst_hard().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        if (tree.isBinarySearchTreeWrapper()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}
