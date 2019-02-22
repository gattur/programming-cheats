package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.InputMismatchException;

public class SegTree {
	static public int seg[];

	public static void main(String args[]) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine().trim());
		String str[] = br.readLine().split(" ");
		int len = str.length;
		int n_order = (int) (Math.log(len) / Math.log(2));
		if (Math.pow(2, n_order) != len)
			n_order = n_order + 1;

		n_order=(int)Math.pow(2, n_order);
		seg = new int[(2 * n_order) - 1];
		for (int j = 0; j < seg.length; j++) {
			seg[j] = Integer.MIN_VALUE;
		}
		int input[]=new int[n_order];
		for (int i = 0; i < len; i++) {
			input[i]=Integer.parseInt(str[i].trim());
		}
		for (int i = len; i < n_order; i++) {
			input[i]=Integer.MIN_VALUE;
		}
		build_seg(input,0,n_order-1,0);
		int reps=Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < reps; i++) {
			String counte[]=br.readLine().split(" ");
			int l=Integer.parseInt(counte[0].trim());
			int h=Integer.parseInt(counte[1].trim());
			int a=findMax(l-1,h-1,0,(n_order-1),0);
			sb.append(a+"\n");
		}
		 System.out.println(sb);
	}

	private static int findMax(int i, int j, int low, int high, int pos) {
		if(i<=low && j>=high)
			return seg[pos];
		if(high<i || j<low)
			return Integer.MIN_VALUE;
		else {
			int mid=(low+high)/2;
			int left=findMax(i,j,low,mid,(pos*2)+1);
			int right=findMax(i,j,mid+1,high,(pos*2)+2);
			
			return Math.max(left, right);
		}
	}

	private static void build_seg(int[] input, int min, int max,int pos) {

		if(min==max) {
			seg[pos]=input[min];
			return;
		}
		int mid=(min+max)/2;
		build_seg(input,min,mid,(2*pos)+1);
		build_seg(input,mid+1,max,(2*pos)+2);
		seg[pos]=Math.max(seg[((int)(pos*2))+1], seg[((int)(pos*2))+2]);
	}

}
