/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int one = 0, zero = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		
		while((test--)>0){
		    
		    one = 0;
		    zero = 0;
		    int size = Integer.parseInt(br.readLine());
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    
		    int arr[] = new int[size];
		    int count=0;
		    while(count!=size)
		        arr[count++] = Integer.parseInt(st.nextToken());
		        
	        for(int i=0; i<size; i++){
	            if(arr[i]==arr[(i+1)%size])
	                if(arr[i]==1)
	                    one++;
                    else
                        zero++;
	        }
	        
	        int min = zero;
	        if(min > one)
	            min = one;
		    
		    if((min%2)==0)
		        System.out.println("Bob");
	        else
	            System.out.println("Alice");
		    
		}
	}
}
