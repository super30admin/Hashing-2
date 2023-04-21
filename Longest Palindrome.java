//Time complexity O(n), Space complexity O(1).
public class Solution {
	public int longestPalindrome(String s) {
        int[] map = new int[128];
        //loop each character
        int ans=0;
        for(char ch:s.toCharArray()) {
            //update count score
            map[ch]+=1;
            //if count ==2 add it to total length and reset count of char to 0 again.
            if(map[ch]==2) {
                ans+=2;
                map[ch]=0;
            } 
        }
        //at last just check if entire string is not consumed it means we can add 1 more char to make odd length palindrome
        return ans==s.length()?ans:ans+1;
        
    }
}