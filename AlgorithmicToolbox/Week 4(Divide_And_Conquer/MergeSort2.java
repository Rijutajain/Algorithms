import java.util.*;
import java.io.*;

public class MergeSort2{
	private static int getMergeSort(int a[],int n){
       if(n<2){
       	return 0;
       }
       int mid=n/2;
       int[] l=new int[mid];
       int[] r=new int[n-mid];
       for(int i=0;i<mid;i++){
       	l[i]=a[i];
       }
       for(int i=mid;i<n;i++){
       	r[i-mid]=a[i];
       }
       
       int k1=getMergeSort(l,mid);
       int k2=getMergeSort(r,n-mid);
       //System.out.println(k1+" "+k2);
       int count=merge(a,l,r);
       return k1+k2+count;
	}
	public static int merge(int[] a,int[] l,int[] r){
       int i=0;
       int j=0;
       int k=0;
       int count=0;
        while (i < l.length && j < r.length) {
        if (l[i] <= r[j]) {
            a[k] = l[i];
            i++;

             
        }
        else {
            a[k] = r[j];
            j++;
            count=count+l.length-i;
        }
        k++;
    }
    while (i < l.length) {
        a[k] = l[i];
        i++;
        k++;
    }
    while (j < r.length) {
        a[k] = r[j];
        j++;
        k++;
    }
    return count;
}
	public static void main(String[] args){
		  Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int c=getMergeSort(a,n);
        //for(int i=0;i<n;i++){
        //	System.out.println(a[i]);
        //}
        System.out.println(c);
	}
}
