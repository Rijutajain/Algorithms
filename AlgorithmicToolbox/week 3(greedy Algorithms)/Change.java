import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int ten=m/10;
        int next1=m%10;
        int five=next1/5;
        int next2=next1%5;
        int one=next2;
        return ten+five+one;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

