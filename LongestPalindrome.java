// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        Integer count = 0;
        for(Character iter:s.toCharArray()){
            if(!set.contains(iter)){
                set.add(iter);
            }else{
                count+=2;
                set.remove(iter);
            }
        }
        return count + (set.size()>0 ? 1:0);
    }
}
