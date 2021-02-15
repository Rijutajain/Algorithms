import java.util.*;
import java.io.*;

public class QuickSort{
	private static void getQuickSort(int[] a,int left,int right){
        if(left>=right){
        	return;
        }
        partitioning p=Partition(a,left,right);
        getQuickSort(a,left,p.start-1);
        getQuickSort(a,p.end+1,right);
	}
	private static partitioning Partition(int[] a,int left,int right){
        int x=a[left];
      ArrayList<Integer> n=new ArrayList<Integer>();
      int count1=0;
      int count2=0;
      for(int i=left;i<=right;i++){
      	if(a[i]<x){
      		n.add(a[i]);
      		count1++;
      	}
      }
      for(int i=left;i<=right;i++){
      	if(a[i]==x){
      		n.add(a[i]);
      		count2++;
      	}
      }
      for(int i=left;i<=right;i++){
      	if(a[i]>x){
      		n.add(a[i]);
      	}
      }
      int[] m=new int[n.size()];
      for(int i=0;i<m.length;i++){
      	m[i]=n.get(i);
      }
      System.arraycopy(m,0,a,left,right-left+1);
      partitioning p=new partitioning(left+count1,left+count1+count2-1);
      return p;
	}
	private static class partitioning{
		int start;
		int end;
		partitioning(int first,int last){
			this.start=first;
			this.end=last;
		}
	}
	public static void main(String[] args){
		  Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        getQuickSort(a,0,a.length-1);
        for(int i=0;i<n;i++){
        	System.out.print(a[i]+" ");
        }
	}
}
