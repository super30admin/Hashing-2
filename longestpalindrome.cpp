class Solution {
public:
    int longestPalindrome(string s) {
        unordered_map<char, int> freq;

        // count frequency of each character in the string
        for (char c : s) {
            freq[c]++;   // increment count of character c
        }
        int length = 0;      
        bool hasOdd = false; // flag to check if any character has odd frequency

        // iterate over each character frequency
        for (auto it : freq) {
            // it.second -> frequency of that character

            // if frequency is even, we can use all characters
            if (it.second % 2 == 0) {
                length += it.second;
            }
            else {
                length += it.second - 1;

                // mark that at least one odd-frequency character exists
                hasOdd = true;
            }
        }

        // we can place exactly one character in the center of the palindrome
        if (hasOdd) {
            length += 1;
        }
        return length;
    }
};
