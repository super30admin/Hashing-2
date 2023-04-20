// ## Problem3 (https://leetcode.com/problems/longest-palindrome)
// In this in a palindromic string we need a even number of characters,
// I am using set to find whether the characters exists in pairs, 
// if I find same char in set I am removing and incresing my Length by 2,at the end set contains all single elements ,
// If set is not empty I am incrementing the ans by 1;

// SC:O(N),TC:O(N)

class Solution {
public:
    int longestPalindrome(string s) {
        unordered_set<char>k;
        int count=0;

        for(int i=0;i<s.size();i++)
        {
            if(k.find(s[i]) == k.end())
            {
                k.insert(s[i]);
            }
            else
            {
               k.erase(s[i]);
               count=count+2;
            }
        }
        if(!k.empty())
        count++;
        return count;
    }
};