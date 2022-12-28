// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// 409. Longest Palindrome
class Solution {
    public int longestPalindrome(String s) {
        if(s.length() == 0) return 0;
        HashSet<Character> map = new HashSet<>();
        int length = 0;
        for(int i = 0; i<s.length(); i++){
           char a = s.charAt(i); 
            if(map.contains(a)){
                length += 2;
                map.remove(a);
            }
            else{
                map.add(a);
            }
        }
        if(!map.isEmpty()){
            length += 1;
        }
        return length;
    }
}