//409. Longest Palindrome


/*
go on adding chars into hashset, if already found [this means we can make a pair] so do count+2
at the end, if there are any elements left in the hashset, means not paired but can be added in the middle of palindrome string => do count++
Time complexity: O(N)
Space complexity: O(1)
*/
class Solution {
public:
    int longestPalindrome(string s) {
        
        int count = 0;
        unordered_set<char> hash;
        for(char c:s){
            if(hash.find(c) == hash.end()){
                hash.insert(c);
            }else{
                count += 2;
                hash.erase(c);
            }
        }

        if(!hash.empty()){
            count++;
        }

        return count;
    }
};