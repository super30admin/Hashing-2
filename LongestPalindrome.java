// Time Complexity : O(n)
// Space Complexity : O(1) (as there can be 52 unique characters in the hashset)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* 1. Iterate through the given string  and keep a counter variable and a hashset to track characters.
2.If the character has been encountered before then add 2 to counter variable and delete the character from the hashset. If not add it to hashset.
3. After itrating through all the elements if there are elements in hashset add 1 to count. */
class Solution {
    public int longestPalindrome(String s) {
        //base case
        if(s== null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(set.contains(c)){
             count = count + 2;
             set.remove(c);
            }
            else{
            set.add(c);
            }

        }
        if(!set.isEmpty()){
            count++;
        }
        return count;
        
    }
}
