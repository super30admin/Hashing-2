// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach





Problem 3:  Longest Palindrome

Bruteforce:
Check all possible strings and prepare a power set and then check the largest palindromic string among them.

Time Complexity: 2^n
Space Complexity: O(n)  --> maybe


Using HashSet:
put each char in hashset, if the char is already present in the string, we found the pair and increament the count by 2
return count + 1,

Time Complexity: O(n)
Space Complexity: O(1)
  
  
  
