// Time Complexity : O(n)
// Space Complexity : O(1)
    // n is the length of the given string

// Your code here along with comments explaining your approach
    //We first find the number of letters with frequencies that are odd number. We use a Set data structure for this. When we come across a letter which is already present we remove it from the set, otherwise we add it.
    //With just one traversal we will have the number of letters with odd frequencies. To form a palindrome we take all the even frequent letters and "at max" 1 odd frequent letter. 
    //By subtracting all the letters in the set from the length of the given string, we will have all the even occurrence of the letters. If there any odd number of letters left, we will consider one more letter for the palindrome.

import java.util.*;

class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray())
        {
            if (set.contains(c))
            {
                set.remove(c);
            }
            else
            {
                set.add(c);
            }
        }
        int ans = s.length()-set.size();
        if (set.size()>0)
        {
            ans++;
        }
        return ans;
    }
}