import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Minimaxsum {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
        long sum=0, min=arr.get(0), max=arr.get(0);
        for (int i=0; i<5; i++){
            if(min>arr.get(i))
                min=arr.get(i);
            if(max<arr.get(i))
                max=arr.get(i);
            sum+=arr.get(i);
        }
        System.out.println((sum-max)+" "+(sum-min));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Minimaxsum.miniMaxSum(arr);

        bufferedReader.close();
    }
}
