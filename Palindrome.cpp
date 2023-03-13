class Solution {
    // Time Complexity : O(n)
    // Space Complexity: O(c) // constant as there at max 26 evtries to set 
public:
    int longestPalindrome(string s) {
        unordered_set<char> matchSet;
        int palindromeCount =0;
        for(int i=0;i<s.length();i++){
            if(matchSet.find(s[i]) != matchSet.end()){
                palindromeCount = palindromeCount+2;
                matchSet.erase(s[i]);
            }
            else  matchSet.insert(s[i]);
        }
        if (!matchSet.empty()){
            palindromeCount++;
        }
        return palindromeCount;


    }
};