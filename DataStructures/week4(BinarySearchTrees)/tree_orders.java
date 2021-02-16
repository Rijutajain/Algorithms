import java.util.*;
import java.io.*;

public class tree_orders {
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
	  public class Node{ 

        int key; 
        Node left, right; 
  
       public Node(int item) 
      { 
           key = item; 
           left = right = null; 
      } 
    } 

	public class TreeOrders {
		int n;
		int[] key, left, right;
		Node[] nodes;
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			nodes=new Node[n];

			key = new int[n];
			left = new int[n];
			right = new int[n];
			for (int i = 0; i < n; i++) { 
				key[i] = in.nextInt();
				nodes[i]=new Node(key[i]);
				left[i] = in.nextInt();
				right[i] = in.nextInt();
			}
			for(int j=0;j<n;j++){
				if(left[j]!=-1){
				nodes[j].left=nodes[left[j]];
			}
			if(right[j]!=-1){
				nodes[j].right=nodes[right[j]];
			}

			}
		}//nodes[i].left=nodes[left[i]];
		//wrapper function and recursive function(node,result),wrapper function in main
		public List<Integer> inOrderWrapper(){
			List<Integer> result = new ArrayList<Integer>();
			Node n=nodes[0];
			List<Integer> answer=inOrder(n,result);
			return answer;
		}
		public List<Integer> preOrderWrapper(){
			List<Integer> result = new ArrayList<Integer>();
			Node n=nodes[0];
			List<Integer> answer=preOrder(n,result);
			return answer;
		}
		public List<Integer> postOrderWrapper(){
			List<Integer> result = new ArrayList<Integer>();
			Node n=nodes[0];
			List<Integer> answer=postOrder(n,result);
			return answer;
		}

		public List<Integer> inOrder(Node node,List<Integer> r) {
			
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
			if (node == null){
             return null; 
            }
  
             inOrder(node.left,r); 
             r.add(node.key);
             inOrder(node.right,r); 
                        
			return r;
		}

		public List<Integer> preOrder(Node node,List<Integer> r) {
			
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
             
         if (node == null){
            return null;
        }
        r.add(node.key);
        preOrder(node.left,r); 
        preOrder(node.right,r);      
			return r;
		}

		public List<Integer> postOrder(Node node,List<Integer> r) {
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
			  if (node == null){ 
                return null; 
            }
        postOrder(node.left,r); 
        postOrder(node.right,r); 
        r.add(node.key); 
                        
			return r;
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_orders().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}

	public void print(List<Integer> x) {
		for (Integer a : x) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public void run() throws IOException {
		TreeOrders tree = new TreeOrders();

		tree.read();
			
		print(tree.inOrderWrapper());
		print(tree.preOrderWrapper());
		print(tree.postOrderWrapper());
	}
}
