// Time complexity :  O(n)
// Space complexity : O(n) where n is the length of the string
class Solution {
public:
    int longestPalindrome(string s) {
        unordered_map<char, int> um;
        int result=0;

        for (int i=0;i<s.length();i++)
        {
            um[s[i]]++;
            if (um[s[i]] == 2)
            {
                result+=2;
                um.erase(s[i]);
            }
        }

        for (auto x: um)
        {
            if (x.second % 2 != 0)
            {
                result++;
                break;
            }
        }

        return result;
    }
};
