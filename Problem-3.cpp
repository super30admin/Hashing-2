// Time Complexity : O(N) 

// Space Complexity : O(1) -> O(26)

// Did this code successfully run on Leetcode : Yes

// Appoarch: Created a set to add unique chars and remove them
// after incrementing count. If set is not empty then return
// count + 1 else count.

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int longestPalindrome(string s) {
        set<char> st;
        int count = 0;
        for(auto c : s){
            if(st.find(c) != st.end()){
                count+=2;
                st.erase(c);
            }
            else{
                st.insert(c);
            }
        }
        return st.size() > 0 ? count + 1 : count;

    }
};