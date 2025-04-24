//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPermutation(String s) {
        String newstr  = "";
        List<String> list = new ArrayList<>();
        boolean[] isused = new boolean[s.length()];
        permute(s,newstr,list,isused);
        HashSet<String> hash = new HashSet<>(list);
        ArrayList<String> li = new ArrayList<>(hash);
        return li;
    }
    static void permute(String s , String newstring , List<String> list , boolean[] isused){
        if(s.length() == newstring.length()){
            list.add(newstring);
            return;
        }
        for(int i=0;i<s.length();i++){
            if(!isused[i]){
                char c = s.charAt(i);
                isused[i] = true;
                permute(s,newstring + s.charAt(i),list,isused);
                isused[i] = false;
            }
        }
    }
}