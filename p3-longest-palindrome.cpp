// Time complexity is O(n)
// Space complexity is O(1) - as max size of set would be 52 (26 lowercase and 26 uppercase letters)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
/*
    1. We insert the character of string into the set if it is not present in the set.
    2. Upon traversal of characters of string, whenever we find the same character in the set,
       we remove the character from the set indicating that it occurred twice in the string.
       So, we will increase maxlen by 2.
    3. After removing all the even number of occurences of different characters, we check if
       any element is present in the set. If yes, it indicates that it can be used as middle
       element while forming the palindrome.
*/

class Solution {
public:
    int longestPalindrome(string s) {
        set<char> letters; // to store characters of string
        int maxlen = 0; // to store maximum length of palindrome
        for(int i = 0; i < s.size(); i++) {
            if(letters.find(s[i]) != letters.end()){
                //s[i] has occurred twice in the string (until 'i'th iteration)
                letters.erase(s[i]);
                maxlen += 2;
            }
            else{
                letters.insert(s[i]);
            }
        }
        /*checking if any element is in set indicating that it
        can be used as middle element of palindrom*/
        return (letters.size() > 0) ? maxlen+1 : maxlen;
    }
};
