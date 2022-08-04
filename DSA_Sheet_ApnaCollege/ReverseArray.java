/*
There are two approch to reverse an array or String.
Approach 1: 
        start = 0
        end = n-1
        while(!(start>end))
            swap(arr[start], arr[end])
            start++
            end--
            repeat;


Approach 2: 
        Recursive solution
        swap(arr, start, end){
            if (start>end)||(start==end)
                tmp = arr[start]
                arr[start] = arr[end]
                arr[end] = tmp
                return
            swap(arr, start++, end--)
        }
        
*/



public class ReverseArray{

    static void reverse(int arr[], int n){
        int start=0;
        int end=n;

        if((n%2)==0){
            while(start!=end){
                int tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;
                start++;
                end--;
            }
        }
        else{
            while((start+1)!=end){
                int tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;
                start++;
                end--;
            }
        }
    }

    static void printArray(int arr[], int size)
    {
        for (int i = 0; i < size; i++)
             System.out.print(arr[i] + " ");
          
         System.out.println();
    }

     public static void main(String args[]) {
         
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        printArray(arr, 7);
        reverse(arr, 6);
        System.out.print("Reversed array is \n");
        printArray(arr, 7);
        
    }
}