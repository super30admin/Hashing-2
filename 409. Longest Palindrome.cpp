class Solution {
public:
    // Time Complexity : O(n)
    // Space Complexity :  O(k) (k = alphabet size)
    
    /* 
    Approach:
    In a palindrome, there can be atmost of 1 character with odd frequency, and all other characters have to have even frequencies.
    Since we can rearrange the letters, we will take all the characters (if they have odd count, we will take one less to make it even count). Then, if we encountered an odd frequency, we will simply add 1 (i.e., taking atmost 1 character with odd frequency)
    */ 
    int longestPalindrome(string s) {
        unordered_map<char,int> cnt;

        for(auto c: s)  cnt[c] = cnt.count(c) ? cnt[c]+1 : 1;
        bool has_odd = false;
        int ans = 0;
        for(auto p: cnt){
          if(p.second % 2)  has_odd = true;
          ans += p.second - p.second % 2;
        }

        if(has_odd)  ans+=1;
        return ans;
    }

    
};
