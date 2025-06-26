// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Using a freqMap to store freq of all characters
// one odd frequency is allowed, remaining we perform 2 * (freq/2), this omits the odd characters if any exists


class Solution {
public:
    int longestPalindrome(string s) {
        unordered_map<char, int> freq;
        for (char c : s) {
            freq[c]++;
        }

        int length = 0;
        bool hasOdd = false;

        for (auto& entry : freq) {
            if (entry.second % 2 == 0) {
                length += entry.second;
            } else {
                length += entry.second - 1;
                hasOdd = true;
            }
        }

        if (hasOdd) length += 1;

        return length;        
    }
};