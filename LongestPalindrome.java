// Time Complexity : O(n).
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : Longest palindrome will have pair of letters and a single letter at the center like a pivot. I am storing in HashSet and increasing the counter by 2
// if it's already present and remove it from the Hashset, else add it.

// Your code here along with comments explaining your approach

class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                count += 2;
                set.remove(ch);
            }else{
                set.add(ch);
            }
        }

        if(s.length() != count){ //this is for the single letter that comes as pivot.
            return count+1;
        }
        return count;//All letters are in pairs case.
    }
}