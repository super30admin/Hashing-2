Longest Palindrome
--------------------
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

Answer:-
// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


class Solution {
public:
    int longestPalindrome(string s) {
        unordered_set <char> set;
        int count = 0;

        for (int i=0; i < s.size(); i++) {
            char c = s.at(i);
            if(set.find(c) == set.end()){
                std::cout << "insert = " << c <<std::endl;
                set.insert(c);
            } else {
                count = count + 2;
                std::cout << "erase = " << c <<std::endl;
                std::cout << "count = " << count <<std::endl;
                set.erase(c);                
            }
        }
        if(!set.empty()) {
            count++;
        }
        return count;
    }
};
