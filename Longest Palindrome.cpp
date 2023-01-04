// Time Complexity: O(n)
// Space complexity: O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    int longestPalindrome(string s) {
        int count = 0;
         // using a hashset to maintain the pairs, if we found afain the char then we increase the length by 2 and remive the char from the set else we keep adding to it
        unordered_set<char> set;
        for(int i = 0; i < s.size(); i++) {
            char c = s.at(i);
            if(set.find(c) != set.end()) {
                count += 2;
                set.erase(c);
            }
            else set.insert(c);
        }
        // if there are chars in set, we can add any one to our palindromic string
        if(set.size() != 0) count++;
        return count;
    }
};