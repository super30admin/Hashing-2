// Time Complexity : O(n)
// Space Complexity : O(1)
//https://leetcode.com/problems/longest-palindrome

class Solution {
    Set<Character> set;
    public int longestPalindrome(String s) {
        set = new HashSet<>();
        int count=0;
        for(char c : s.toCharArray()){
            if(set.contains(c)){
                count+=2;
                set.remove(c);
            }else{
                set.add(c);
            }
        }
        if(!set.isEmpty()) count++;
        return count;
    }
}
