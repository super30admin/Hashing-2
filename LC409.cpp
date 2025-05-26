// Time complexity O(n)
// Space complexity O(1)

class Solution {
public:
    int longestPalindrome(string s) {
        int count = 0;
        unordered_set<char> set;
        for (char ch : s) {
            if (set.find(ch) == set.end()) {
                set.insert(ch);
            } else {
                set.erase(ch);
                count += 2;
            }
        }
        if (!set.empty()) {
            count += 1;
        }
        return count;
    }
};