// 409. Longest Palindrome
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
    
iterates through the string, maintaining a set of characters encountered so 
far. If a character is already present in the set, it indicates a pair for a 
palindrome, so the count is incremented by 2, and the character is removed 
from the set. If a character is not in the set, it's added. After iterating 
through the string, if there are any characters left in the set, it means they
can be used as the center of the palindrome, so one additional character can
be added to the count before returning it.

*/
int longestPalindrome(string s) {
        int count = 0;
        unordered_set<char> cset;
        for(int i = 0; i < s.size(); i++)
        {
            if(cset.find(s[i]) != cset.end())
            {
                cset.erase(s[i]);
                count += 2;
            }
            else
                cset.insert(s[i]);
        }
        if(cset.empty())
            return count;
        return count + 1;
    }