import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
    	int[] coins={1,3,4};
        int[] minNum=new int[m+1];
        int NumCoins=0;
        minNum[0]=0;
        for(int i=1;i<minNum.length;i++){
             minNum[i]=10*10*10*10*10*10*10*10;
             for(int k=0;k<coins.length;k++){
             	if(i>=coins[k]){
                  NumCoins=minNum[i-coins[k]]+1;
                }
                if(NumCoins<minNum[i]){
                	minNum[i]=NumCoins;
                }
             	
             }
        }
        return minNum[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

