import java.util.*;
import java.io.*;

public class tree_height {
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
        ArrayList<Node> children;
             Node(){
             children = new ArrayList();
   }
}

	public class TreeHeight {
		int n;
		int parent[];
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
		}
		public Node MakingTree(){
			 Node[] allNodes = new Node[n];
         Node rootNode = null;
         //initially all objects in array will be null
         for(int i=0; i < n; i++){
             allNodes[i] = new Node();
         }
           
         for(int i=0; i<n; i++){
           int childIndex = i;
           int parentIndex = parent[i];
           if(parentIndex == -1){
              rootNode = allNodes[i];
           }else{
              Node parentNode = allNodes[parentIndex];
               Node childNode = allNodes[childIndex];
              parentNode.children.add(childNode);
           }
         }
         return rootNode;
		}
		public int computeHeightWrapper(){
			Node rootnode=MakingTree();
			int tall=computeHeight(rootnode);
			return tall;
		}

		public int computeHeight(Node m) {
                        // Replace this code with a faster implementation
			/*int maxHeight = 0;
			for (int vertex = 0; vertex < n; vertex++) {
				int height = 0;
				for (int i = vertex; i != -1; i = parent[i])
					height++;
				maxHeight = Math.max(maxHeight, height);
			}
			return maxHeight;*/
		//Node rootnode=MakingTree();
		int n=m.children.size();
		int heightMax=0;
		    if(m.children.size()==0){
				return 1;
			}
		for(int i=0;i<n;i++){
			
			int currHeight=computeHeight(m.children.get(i));
			if(currHeight>heightMax){
				heightMax=currHeight;
			}
		}
	   return 1+heightMax;

	}
}
	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeightWrapper());
	}
}

