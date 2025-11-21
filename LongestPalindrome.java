// Time Complexity : O(n) -> n is the length of the input string
// Space Complexity : O(1) -> O(constant)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1: We use a HashSet to store characters that we have encountered in the input string
// 2: If a character has already been seen, we update the count by 2 and remove the character from the set
// 3: If the set has a character after iteration on the input is complete, we add 1 to the count and return count
class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                count += 2;
                set.remove(ch);
            }
            else set.add(ch);
        }
        if(!set.isEmpty()) return count + 1;
        return count;
    }
}