// Time Complexity: O(n), where n is the length of the string.
// Space Complexity: O(1), since the string contains only uppercase and lowercase English letters, the HashSet can contain at most 52 characters.

// Approach: Maintain a HashSet to store unpaired characters and initialize a counter to zero.
// Iterate through the string, and if a character is already present in the set, increment the counter by 2 and remove it; otherwise, add it to the set.
// After iteration, if the set is not empty, increment the counter by 1 to include an unpaired character in the middle of the palindrome.

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int longestPalindrome(String s) {
        if(s.length() == 0){
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                count +=2;
                set.remove(s.charAt(i));
            }else{
                set.add(s.charAt(i));
            }
        }
        if(set.size() > 0){
            count = count+1;
        }
        return count;
    }
}
