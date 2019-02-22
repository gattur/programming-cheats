import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BIT{
    public static void main(String args[])  throws java.lang.Exception, NumberFormatException, IOException{
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	int times=Integer.parseInt(br.readLine());
    	for (int i = 0; i < times; i++) {
    		br.readLine();
    		int n=Integer.parseInt(br.readLine());
    		int nos[]=new int[n+1];
    		for (int j = 0; j < n; j++) {
				nos[j]=Integer.parseInt(br.readLine());
			}
    		int newwer[]=new int[n];
    		for (int j = 0; j < newwer.length; j++) {
				int count=1;
    			for (int j2 = 0; j2 < newwer.length; j2++) {
					if(nos[j]>nos[j2])
						count=count+1;
				}
    			newwer[j]=count;
			}
    		int inversions=0;
    		int numbers[]=new int[n+1];
    		for (int j = 1; j <= n; j++) {
				int i1=n;
				while(i1>0) {
					inversions=inversions+numbers[i1];
					i1=i1-Integer.lowestOneBit(i1);
				}
				i1=newwer[j-1];
				while(i1>0) {
					inversions=inversions-numbers[i1];
					i1=i1-Integer.lowestOneBit(i1);
				}
				i1=newwer[j-1];
				while(i1<numbers.length) {
					numbers[i1]=numbers[i1]+1;
					i1=i1+Integer.lowestOneBit(i1);
				}
			}
    		sb.append(inversions+"\n");
		}
    	
    	System.out.println(sb);
	}
}
