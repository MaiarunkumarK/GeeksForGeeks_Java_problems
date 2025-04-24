//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);       // Odd-length palindrome
            int len2 = expandAroundCenter(s, i, i + 1);   // Even-length palindrome
            int len = Math.max(len1, len2);

            int newStart = i - (len - 1) / 2;
            int newEnd = i + len / 2;

            // Update if longer OR same length but appears earlier
            if (len > (end - start + 1) || (len == (end - start + 1) && newStart < start)) {
                start = newStart;
                end = newEnd;
            }
        }

        return s.substring(start, end + 1);
    }

    static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
