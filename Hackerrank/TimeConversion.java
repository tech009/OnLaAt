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

class TimeConversion {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
    // Write your code here
         String res;
         String listTime[] = s.split(":");
         String hour = listTime[0];
         String minutes = listTime[1];
         String secounds = listTime[2].substring(0, 2);
         String caser = listTime[2].substring(2, 4);
         if(caser.equals("AM")){
             if(hour.equals("12"))
                    hour="00";
 
            res = (hour+":"+minutes+":"+secounds);
         }else{
             if(!hour.equals("12")){
                 int h = Integer.parseInt(hour); 
                 h = h +12; 
                 hour =""+h; 
             }
            res = (hour+":"+minutes+":"+secounds);
         }
         return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = TimeConversion.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
