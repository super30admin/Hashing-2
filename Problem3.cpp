// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;

class Solution {
public:
    int longestPalindrome(string s) {
        unordered_map<char, int> m;
        int length = 0;
        bool hasodd = false;

        // Count frequency of each character
        for (int i = 0; i < (int)s.size(); i++) {
            m[s[i]]++;
        }

        // Process counts
        for (auto &p : m) {
            int count = p.second;

            if (count % 2 == 0) {
                length += count;            // use all even counts
            } else {
                hasodd = true;
                length += (count - 1);      // use even part, leave 1 aside
            }
        }

        // one odd char can go in the center
        if (hasodd) length += 1;

        return length;
    }
};