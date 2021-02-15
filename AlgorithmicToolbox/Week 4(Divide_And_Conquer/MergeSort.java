import java.util.*;
import java.io.*;

public class MergeSort{
	private static int[] getMergeSort(int a[],int left,int right){
       if(left+1==right){
       	return a;
       }
    int n1=(left+right)/2-left+1;
    int n2=right-(left+right)/2;
    int[] l=new int[n1];
    int[] r=new int[n2];
    for(int i=0;i<n1;i++){
    	l[i]=a[l+i];
    }
     for(int j=0;j<n2;j++){
    	r[j]=a[j+n1];
    }
    getMergeSort(l,left,(left+right)/2);
    getMergeSort(r,(left+right)/2+1,right);
    int[] arr=Merge(a,l,r,left);
    return arr;
	}

	public static int[] Merge(int[] l,int[] r,int left){
		int[] D=new int[l.length+r.length];
		int i=0;
		int j=0;
      int k=0;
      while(i<l.length && j<r.length){
      	if(l[i]<r[j]){
      		D[k]=l[i];
      		i++;
      	}
      	else{
      		D[k]=r[j];
      		j++;
      	}
      	k++;
      }
      return D;
	}
	public static void main(String[] args){
		  Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] arr=getMergeSort(a,0,a.length-1);
        for(int i=0;i<arr.length;i++){
        	System.out.println(arr[i]);
        }
	}
}
