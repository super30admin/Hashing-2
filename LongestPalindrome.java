class Solution {
    public int longestPalindrome(String s) {
        // Example: 
        // Input: s = "abccccdd"
        // Output: 7 -Longest Palindrome 
        // edge case
        if ( s == null || s.length() == 0) return 0;
        // Algorithm
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        // Step 1: 
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(set.contains(c)) {
                count += 2;
                set.remove(c);
            } else {
                set.add(c);
            }
        }
         if(!set.isEmpty()) count++;
         return count;
        
    }
}
