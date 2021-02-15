import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
      int n=exp.length()/2+1;
      long[][] min=new long[n][n];
      long[][] max=new long[n][n];
       for (int i = 0; i < n; i++) 
        { 
            min[i][i]=Long.parseLong(String.valueOf(exp.charAt(i*2)));
            max[i][i]=Long.parseLong(String.valueOf(exp.charAt(i*2)));
        //min[i][i]=Integer.parseInt(String.valueOf(exp.charAt(i*2)));
        //max[i][i]=Integer.parseInt(String.valueOf(exp.charAt(i*2)));
        }
           for(int size = 1; size <= n - 1; size++) {
            for(int i = 0; i <= n - 1 - size; i++) {
                int j = size + i;  
                long[] res = getMinAndMax(exp, i, j, min, max);
                min[i][j] = res[0];
                max[i][j] = res[1];
            }
        }
         
        
    
    return max[0][n-1];
    }
    private static long[] getMinAndMax(String exp,int i,int j,long[][] min,long[][] max){
        long[] res = new long[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        for(int index = i; index <= j - 1; index++) {
            char oper = exp.charAt(index * 2 + 1);
            long a = eval(min[i][index], min[index + 1][j], oper),
                    b  = eval(min[i][index], max[index + 1][j], oper),
                    c  = eval(max[i][index], min[index + 1][j], oper),
                    d  = eval(max[i][index], max[index + 1][j], oper);
            res[0] = (long) Math.min(a, Math.min(b,
                    Math.min(c, Math.min(d, res[0]))));
            res[1] = (long) Math.max(a, Math.max(b,
                    Math.max(c, Math.max(d, res[1]))));
        }
        return res;
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

