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

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int gcd(int a, int b){
        if (b==0)
        return a;
        return gcd(b, a%b);
    }
    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
        int lcm=a.get(0), gcd=b.get(0), count=0;
        for(int i=1; i<a.size(); i++){
            int tmp = 0, tmp1 = lcm;
            
            if(lcm > a.get(i))
                tmp = gcd(lcm, a.get(i));
            else
                tmp = gcd(a.get(i), lcm);
            lcm = (tmp1*a.get(i))/tmp;    
        }
        
        for(int i=1; i<b.size(); i++){
            if(gcd > b.get(i))
                gcd = gcd(gcd, b.get(i));
            else
                gcd = gcd(b.get(i), gcd);
        }
        
        int lcmO = lcm;
        while(lcm <= gcd){
            if ((gcd%lcm)==0)
                count++;
            lcm+=lcmO;
        }
        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
