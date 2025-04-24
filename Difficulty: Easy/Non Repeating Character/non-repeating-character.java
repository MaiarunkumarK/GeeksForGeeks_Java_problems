//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String st = sc.next();

            char ans = new Solution().nonRepeatingChar(st);

            if (ans != '$')
                System.out.println(ans);
            else
                System.out.println(-1);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static char nonRepeatingChar(String s) {
        HashMap<Character,Integer> hash = new HashMap<>();
        for(char c : s.toCharArray()){
            hash.put(c,hash.getOrDefault(c,0)+1);
        }
        for(int i=0;i<s.length();i++){
            if(hash.get(s.charAt(i)) == 1){
                return s.charAt(i);
            }
            
        }
        return '$';
        
        
    }
}
