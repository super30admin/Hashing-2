/*

// Time Complexity : O(N) length of the string
// Space Complexity : O(1) constant cause fixed arr length to store hash set
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

*/

#include<vector>
#include<string>

using namespace std;

class Solution {
    const int vec_len{123-65};
public:
    int longestPalindrome(string s) {
        int count{},pal_long{};
        vector<bool> hash_set(vec_len,false);
        for(auto ch:s){
            int key = ch-65;
            // storing the ocurrence of the alphabet
            if(hash_set.at(key) == false){
                hash_set.at(key) = true;
                ++count;
            }
            // if occured add two to the pal_long cause 2 characters and remove the alphabet
            else {
                pal_long+=2;
                hash_set.at(key)=false;
                --count;
            }
        }// check if some remainig so any single element can be held in middle for the odd palindrome,
        if(count>0){
            ++pal_long;
        }
        return pal_long;
    }
};