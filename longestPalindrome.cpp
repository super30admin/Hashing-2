// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I was getting error to  use find command for hast set in leet code. So i have used hashmap instead with dummy value as 0.

// Your code here along with comments explaining your approach


class Solution {
public:
    int longestPalindrome(string s) {
        map<char,int> myhash;
        int result = 0;
        
        for (int i =0; i < s.size(); i ++){
            char key = s.at(i);
            if (!myhash.count(key)){
                myhash.insert({key,0});
            }
            else{
                myhash.erase(key);
                result += 2;
            }
        }
       return myhash.empty() ? result : result +1;
    }
};