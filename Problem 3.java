//Step 1 add the count of character to an array of fixed length.
//Step 2 add the closest even to the count and check is sum is even and the count is odd, if true increase the count.

class Solution {
    public int longestPalindrome(String s) {
        int[] arr= new int[126];
        int ans=0;
    
        for(char c : s.toCharArray())
                arr[c]++;
    
        for(int v:arr)
        {
            ans+=v/2 * 2;
            
            if(ans%2==0 && v%2==1)
                ans++;
        }
        return ans;
    }
}