// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int longestPalindrome(String s) {
        if(s==null) return -1;
        HashSet<Character> set = new HashSet<>();
        int count=0;
        for(int i=0; i<s.length();i++)
        {
            char c=s.charAt(i);
           if(set.contains(c))
           {
               set.remove(c);
               count+=2;
           }
           else
           set.add(c);
        }
        if(!set.isEmpty())
        count+=1;
     return count;
    }
}