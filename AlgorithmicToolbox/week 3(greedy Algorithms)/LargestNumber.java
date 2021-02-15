import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        ArrayList<String> k=new ArrayList<String>(Arrays.asList(a));
        String result="";
       while(k.size()>0){
        String largest=k.get(0);
        for(int i=0;i<k.size();i++){
            //int aj=Integer.parseInt(k.get(i));
            if(IsGreaterOrEqual(k.get(i),largest)==true){
                largest=k.get(i);
            }
        }
        //String h=String.valueOf(largest);
         result=result+largest;
          k.remove(largest);

     }
           return result;
    }
        /*String result = "";
        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        return result;
        */
    
     private static boolean IsGreaterOrEqual(String s1,String s2){
        String con1=s1+s2;
        String con2=s2+s1;
        if((con1).compareTo(con2)<0){
            return false;
        }
        else{
            return true;
        }
     }
    public static void main(String[] args) {
        //System.out.println("Hello World");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

