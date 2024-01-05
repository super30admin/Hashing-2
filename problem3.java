// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// For each character ch[i], it checks if the HashSet already contains the character.
// If it does, it means there is a pair, and the count of characters forming a palindrome increases by 2.

import java.util.HashSet;

class problem3 {
    public int longestPalindrome(String s) {
        char[] ch = s.toCharArray();
        HashSet<Character> hashSet = new HashSet<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(hashSet.contains(ch[i])){
                hashSet.remove(ch[i]);
                count += 2;
            }
            else hashSet.add(ch[i]);

        }
        if(!hashSet.isEmpty()) count++;
        return count;
    }
}