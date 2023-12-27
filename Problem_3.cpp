/*
 * Time Complexity : O(n)
 * Space Complexity : O(1) as only 26 chars
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No


 ? Your code here along with comments explaining your approach
    The approach I use focuses on pairing characters and recognizing
    that a palindrome is mainly composed of pairs of characters with
    potentially one unpaired character in the middle for odd-length
    palindromes.

    To implement this, I use an unordered set char_set to track
    characters from the string. As I iterate through each character c
    in the string s, I check if c is already in char_set. If it is,
    this means I've found a pair for c. So, I remove c from the set
    and increase palindrome_length by 2 (as a pair contributes two
    characters to the palindrome length).

    If c is not in the set, it means I haven't found a pair for
    it yet, so I insert c into char_set.

    After processing all characters in the string, I check if char_set
    is not empty. If it's not empty, it means there are characters that
    could not be paired. In a palindrome, I can use one such unpaired
    character as the center of the palindrome, adding 1 to the total
    palindrome length. Hence, if char_set is not empty, I return
    palindrome_length + 1; otherwise, I return palindrome_length as is.

    This logic ensures that the function accurately computes the length
    of the longest possible palindrome that can be constructed using the
    characters of the input string s.

*/

#include <string>
#include <unordered_set>

class Solution {
public:
    int longestPalindrome(std::string s) {
        std::unordered_set<char> char_set;
        int palindrome_length = 0;
        for (const char& c : s) {
            if (char_set.contains(c)) {
                char_set.erase(c);
                palindrome_length += 2;
            } else {
                char_set.insert(c);
            }
        }

        return !char_set.empty() ? palindrome_length + 1 : palindrome_length;
    }
};