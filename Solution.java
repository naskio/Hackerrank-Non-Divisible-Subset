import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int nonDivisibleSubset(int k, int[] arr) {
        int[] remains=new int[k];
        for (int i=0;i<arr.length;i++){
            remains[arr[i]%k]++;
        }
        int result=0;
        if (remains[0]>0){
            result++;
        }
        for (int i=1;i<remains.length;i++){
            if(i==(k-i)){
                result++;
            }else {
                if (remains[i]>=remains[k-i]){
                    result+=remains[i];
                }else {
                    result+=remains[k-i];
                }
                remains[i]=0;
                remains[k-i]=0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = nonDivisibleSubset(k, arr);
        System.out.println(result);
        in.close();
    }
}
