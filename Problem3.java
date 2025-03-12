/*
 * TC - O(n)
SC - O(1)

The code iterates through the string, using a HashSet to track unpaired characters.
When a character is found again, it forms a pair, so result is incremented by 2, and the character is removed from the set.
If there are any unpaired characters left in the set, one can be placed at the center of the palindrome, so 1 is added to result.
 */

 class Solution {
    public int longestPalindrome(String s) {
    
    int result = 0;
    HashSet<Character> set = new HashSet<>();
    
    for (int i = 0; i < s.length(); i ++) {
        char ch = s.charAt(i);
        if (set.contains(ch)) {
            result += 2;
            set.remove(ch);
        } else {
            set.add(ch);
        }
    }
    if (!set.isEmpty()){
        result ++;
    }
    return result;
    }
}