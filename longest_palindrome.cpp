// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Idea is to add the characters to the set initially and when we encounter
// them again erase those characters and increment count by 2. At the end if the size of 
// set is > 0 then we add 1 to the count. This gives the length of longest palindrome.

#include<string>
#include<unordered_set>

class Solution {
public:
    int longestPalindrome(std::string s) {
        int count = 0;
        if(s.length() == 0)
        {
            return count;
        }

        // to track characters.
        std::unordered_set<char> set;
        for(int i = 0; i< s.length(); i++)
        {
            char ch = s[i];
            if(set.find(ch) == set.end())
            {
                // When set doesnt have that char
                set.insert(ch);
            }
            else
            {
                // when set already has that char
                set.erase(ch);
                count = count+2;
            }
        }
        
        if(set.size() > 0)
        {
            count++;
        }
        return count;
    }
};