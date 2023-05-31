// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
public:
    int longestPalindrome(string s) {
        map<char,int> mp;
        int count = 0;  

        for(int i = 0; i < s.size(); i++) {
            if(mp[s[i]] != 0) {
                mp[s[i]]++;
                if(mp[s[i]] == 2) {
                    count += 2; 
                    mp.erase(s[i]);
                }
            } else mp[s[i]]++;
        }

        if(mp.size() != 0) count++; 
        return count;        
    }
};