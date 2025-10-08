// 409. Longest Palindrome
// https://leetcode.com/problems/longest-palindrome/description/

/**
 * Time Complexity: O(n) since we iterate over all characters
 * Space Complexity: O(n) because in worst case every character can be unique
 */

class Solution {
    public int longestPalindrome(String s) {
        int count = 0;
        HashSet<Character> set = new HashSet();

        for(Character ch : s.toCharArray()){
            if(set.contains(ch)){
                set.remove(ch);
                count += 2;
            }else{
                set.add(ch);
            }
        }

        if(set.size() > 0){
            count +=1;
        }

        return count;
    }
}