// Time Complexity : O(n)
// Space Complexity : O(1) because its a character set
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int longestPalindrome(String s) {
        int count = 0;

        // set should work because we just need to check if the element is already present or not
        HashSet<Character> set = new HashSet<>();

        // iterate through the string and if the character in the string is already in the set, that means we found a pair
        // increment counter by 2 coz we need to find length, remove the element and if the element is not present, add the element to the set
        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.charAt(i))){
                count += 2;
                set.remove(s.charAt(i));
            }
            else
                set.add(s.charAt(i));
        }
        if(!set.isEmpty())
            count += 1;
        return count;
    }
}
