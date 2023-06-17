// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>
#include <unordered_map>
  
using namespace std;

//implementing using hashmap to store the repeated occurance of that character
class Solution {
public:
    int longestPalindrome(string s) {
        unordered_map<char, int> char_no;
        int count = 0;
        for(int i =0; i <= s.size() - 1; i++){
            if(char_no.find(s[i]) == char_no.end()){
                char_no.emplace(make_pair(s[i], 1));
            }
            else{
                char_no[s[i]]++;
            }
            if(char_no[s[i]] == 2){
                char_no.erase(s[i]);
                count = count + 2;
            }
        }
        // if list not empty add 1 to count as we can use one non repeated element in palindrome
        if(char_no.size() > 0){
            count++;
        }
        return count;
    }
};