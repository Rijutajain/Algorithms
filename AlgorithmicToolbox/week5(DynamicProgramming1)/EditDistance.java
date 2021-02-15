import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    int m=s.length();
    int n=t.length();
    int[][] edist=new int[m+1][n+1];
    for(int i=0;i<=m;i++){
      for(int j=0;j<=n;j++){
        if(i==0){
          edist[i][j]=j;
        }
        else if(j==0){
          edist[i][j]=i;
        }
        else if(s.charAt(i-1)==t.charAt(j-1)){
          edist[i][j]=edist[i-1][j-1];
        }
        else{
          edist[i][j]=1+min(edist[i][j-1],edist[i-1][j],edist[i-1][j-1]);
        }
      }
    }
    return edist[m][n];
  }
   public static int min(int one,int two,int three){
          if(one<=two && one<=three){
            return one;
          }
          if(two<=one && two<=three){
            return two;
          }
          if(three<=one && three<=two){
            return three;
          }
          return -1;
    }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
