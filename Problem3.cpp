// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
public:
    int longestPalindrome(string s) {
       unordered_set<char> st;
        int count=0;
        for(int i=0;i<s.size();i++)
        { 
        // If the character is already in the set, it can be part of a palindrome.
        // Increment count by 2 and remove the character from the set.
            if(st.find(s[i])!=st.end())
            {
                count+=2;
                st.erase(s[i]);
            }
        // If the character is not in the set, add it to the set.
            else{
                st.insert(s[i]);
            }
        }
         // If there are characters remaining in the set, add 1 to the count.
        if(st.size()>0) return count+1;
        return count;
    }
};