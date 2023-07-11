// Time Complexity : O(n)
// Space Complexity :O(1) // only 26 characters
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

class Solution {
public:
    int longestPalindrome(string s) {
        unordered_set<char> set;

        int count = 0;

        for(int i=0;i<s.length();i++){
            char c = s[i];
            if(set.find(c)!= set.end()){
                count+=2;
                set.erase(c);

            }
            else{
                set.insert(c);

            }

        }

        if(!set.empty()){
            return count+1;
        }
        return count;

        
    }
};