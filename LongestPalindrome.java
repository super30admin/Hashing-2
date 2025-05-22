/* Problem 1:
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : yes
*/

class Solution {
    public int longestPalindrome(String s) {

        Set<Character> set = new HashSet<>();
        int count =0;

        for(char c : s.toCharArray()){
            System.out.println(c);

            if(!set.contains(c)){
                set.add(c);
            }else{
                count+=2;
                set.remove(c);

            }
        }

        if(!set.isEmpty()) return count+1;

        return count;
        
    }
}