// Program to find minimum and maximum of an element in least number of comparisions.
/*
Approach 1: Linear Comparision across the array and find min and max.

Initialize min and max, and make a comparision if min is greater than current element and max is less than current element.
Worst Case number of comparisions: 1+2(n-2)
Best Case number of comparisions: 1+n-2

Approach 2: Tournament Method
This is a divide and conquer method of solving min and max.
Pair MaxMin(array, array_size)
   if array_size = 1
      return element as both max and min
   else if arry_size = 2
      one comparison to determine max and min
      return that pair
   else    // array_size  > 2 
      recur for max and min of left half
      recur for max and min of right half
      one comparison determines true max of the two candidates
      one comparison determines true min of the two candidates
      return the pair of max and min
*/


class MinimumAndMaximum{

    static class Pair{
        int min;
        int max;

    }

    static Pair getMinMax(int arr[], int low, int high){

        Pair minmax = new Pair();
        Pair mml = new Pair();
        Pair mmr = new Pair();

        if (low == high){
            minmax.min = arr[low];
            minmax.max = arr[low];
            return minmax;
        }

        if (low == high+1){
            if(arr[low]>arr[high]){
                minmax.max = arr[low];
                minmax.min = arr[high];
            }
            else{
                minmax.max = arr[high];
                minmax.min = arr[low];
            }
            return minmax;
        }

        int mid = (low+high)/2;
        mml = getMinMax(arr, low, mid);
        mmr = getMinMax(arr, mid+1, high);

        if(mml.min > mmr.min)
            minmax.min = mmr.min;
        else
            minmax.min = mml.min;

        if(mml.max > mmr.max)
            minmax.max = mml.max;
        else
            minmax.max = mmr.max;

        return minmax;
    }

    /* Driver program to test above function */
    public static void main(String args[]) {
        int arr[] = {1000, 11, 445, 1, 330, 3000};
        int arr_size = 6;
        Pair minmax = getMinMax(arr, 0, arr_size - 1);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d\n", minmax.max);
 
    }
}
