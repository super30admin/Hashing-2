// Time Complexity : O(n) for both hashmap & hashset solution
// Space Complexity : O(1) for both hashmap & hashset solution
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Hashmap approach:
// Maintain a hashmap of characters and their counts
// Iterate over the map and build the palindrome by adding all the even count characters
// Add only one odd count character to make sure that the palindrome condition is valid

// Hashset approach:
// Iterate over the string and add characters encountered to a hashset
// If we already have encountered the character, remove it from the set and add +2 to the length (create a pair)
// If there are any elements remaining in the set (odd characters which are unpaired), add +1 to the length before returning

#include <iostream>
#include <unordered_map>
#include <unordered_set>
using namespace std;

class Solution {
public:
    int longestPalindromeSet(string s) {
        unordered_set<char> encountered; // to check if we have already encountered a char
        int longest = 0;
        for(auto& ch:s) {
            if(encountered.find(ch) == encountered.end()) { // insert in set if we havent already encountered 
                encountered.insert(ch);
            } else { // we have encountered already
                longest += 2; // increase length by 2 and remove char from set
                encountered.erase(ch);
            }
        }
        if(encountered.empty()) return longest; // if there are no chars which occur odd number of times (unpaired)
        return longest + 1; // add one odd length char
    }

    int longestPalindrome(string s) {
        unordered_map<char, int> characterCounts;
        for(auto& ch : s){ // maintain a count of the number of occurences of each individual character
            characterCounts[ch]++;
        }
        bool oddFlag = false; // we can only take one odd valued char, use a flag to track that
        int longest = 0; 
        for(auto& it : characterCounts) {
            if(it.second%2 != 0) { // odd character count
                if(!oddFlag){ // if we haven't included an odd char yet
                    longest += it.second; 
                    oddFlag = true; // make this true so that we don't include any more odd counts
                } else {
                    longest += it.second - 1; // if we already included an odd char
                }
            } else {
                longest += it.second; // even char
            }
        }
        return longest;
    }
};

int main() {
    Solution solution;
    string s = "abccccdd";
    string t = "abcdefg";
    string u = "AaBbCc";
    string v = "a";

    cout<<"(Map Solution) Longest Palindrome length: "<<solution.longestPalindrome(s)<<endl;
    cout<<"(Set Solution) Longest Palindrome length: "<<solution.longestPalindromeSet(s)<<endl;
    cout<<"\n";

    cout<<"(Map Solution) Longest Palindrome length: "<<solution.longestPalindrome(t)<<endl;
    cout<<"(Set Solution) Longest Palindrome length: "<<solution.longestPalindromeSet(t)<<endl;
    cout<<"\n";

    cout<<"(Map Solution) Longest Palindrome length: "<<solution.longestPalindrome(u)<<endl;
    cout<<"(Set Solution) Longest Palindrome length: "<<solution.longestPalindromeSet(u)<<endl;
    cout<<"\n";

    cout<<"(Map Solution) Longest Palindrome length: "<<solution.longestPalindrome(v)<<endl;
    cout<<"(Set Solution) Longest Palindrome length: "<<solution.longestPalindromeSet(v)<<endl;
    cout<<"\n";

    return 0;
}