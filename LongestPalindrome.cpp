#include <iostream>
#include <set>

using namespace std;

//Time complexity : O(n)
//Space Complexity : O(1)
//Leetcode : Yes

class Solution {
public:
    int longestPalindrome(string s) {
        set<char> lpallindrome;
        int totalLength = 0;
        for(char c : s)
        {
            if(lpallindrome.find(c) != lpallindrome.end())
            {
                totalLength += 2;
                lpallindrome.erase(c);
            }
            else
            {
                lpallindrome.insert(c);
            }
        }
        
        if(!lpallindrome.empty())
        {
            totalLength+=1;
        }
        
        return totalLength;
    }
};