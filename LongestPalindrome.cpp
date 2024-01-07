// Time Complexity : O(n)
// Space Complexity : O(n) as we maintain a set
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
#include<unordered_set>
#include<string>
#include<vector>
using namespace std;
class Solution {
public:
    int longestPalindrome(string s) {
        
        unordered_set<char> hashSet;
        int res=0;
        for(int i=0;i<s.length();i++)
        {
            if(hashSet.count(s[i]))
            {
                res+=2;
                hashSet.erase(s[i]);
            }
            else
            {
                hashSet.insert(s[i]);
            }
        }
        if(!hashSet.empty())
            res+=1;
        return res;
    }
};