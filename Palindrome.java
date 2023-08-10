// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// I am using a Character Hashset and adding each new character to the set
// If a character appears twice, then remove the first instance 
// and add 2 to the counter. At the end, if the HashSet is not empty then add 1 to
// the counter.
class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> pally = new HashSet<>();
        int counter = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(pally.contains(c)){
                counter += 2;
                pally.remove(c);
            }else{
                pally.add(c);
            }
        }
        if(!pally.isEmpty()){
            counter += 1;
        }
        return counter;
    }
}