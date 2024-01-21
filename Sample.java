// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int longestPalindrome(String s) {
        Set<Character> seen = new HashSet<>();
        int count = 0;

        for(Character c : s.toCharArray()){
            if(seen.contains(c)){
                count+=2;
                seen.remove(c);
            } else seen.add(c);
        }

        return count + (seen.isEmpty() ? 0 : 1);


    }
}
