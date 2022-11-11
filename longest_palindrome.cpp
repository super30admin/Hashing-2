// time complexity O(n)
// space complexity O(1)

#include <unordered_set>
#include <string>
using namespace std;

class Solution
{
public:
    int longestPalindrome(string s)
    {
        // implement a solution using hashset

        unordered_set<char> s_map;
        int count = 0;

        for (int i = 0; i < s.size(); i++)
        {
            // if key is not present in set
            char req = s[i];
            if (s_map.find(req) == s_map.end())
            {
                s_map.insert(req);
            }

            else
            {
                count = count + 2;
                s_map.erase(req);
            }
        }

        if (s_map.empty() != true)
        {
            count++;
        }

        return count;
    }
};