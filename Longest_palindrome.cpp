#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int longestPalindrome(string s) {
        int cnt=0;
        unordered_set<char>set;
        for(int i=0;i<s.length();i++){
            char ch = s[i];
            if(set.find(ch)!=set.end()){
                cnt+=2;
                set.erase(ch);
            }else{
                set.insert(ch);
            }
        }
        if(!set.empty())
            cnt++;
        return cnt;

        
    }
};