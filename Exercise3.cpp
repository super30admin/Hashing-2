// Problem: Longest Palindrome
//  Time Complexity : O(n)
//  Space Complexity : O(1)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three
// sentences only
// 1. We maintain an unoredered_set to check if the character is already present
// 2. If present, that means it's the second time so we add +2 to the result and
// remove the ch
// 3. If at last our set is not empty, this means this is odd frequency char, so
// we can take any one of them and add 1 to the result
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int longestPalindrome(string s) {
    unordered_set<char> se;
    int res = 0;
    for (char ch : s) {
      if (se.count(ch) > 0) {
        res += 2;
        se.erase(ch);
      } else {
        se.insert(ch);
      }
    }
    if (!se.empty())
      res++;
    return res;
  }
};
