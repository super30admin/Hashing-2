// Time Complexity : O(n) where n is the size of the array 
// Space Complexity : O(1) -> the max size is upperbounded by the alphabet size (26 or 52)
// Did this code successfully run on Leetcode : Yes

/* 
Approach 1
Create a map with the counts of each letter 
For each pair of letter, add 2 to the count 
if the length of the string is odd, increase the count by 1 (there has to be 1 letter which is a lone wolf)
*/

class Solution {
public:
    int longestPalindrome(string s) {
        unordered_map<char, int> s_map;
        int count = 0;

        //create the map with count of each letter
        for(char c:s){
            s_map[c]++;

            //every time the count becomes even, increase count by 2
            //for 1, 3, 5 etc we are not increasing the count 
            //increase it when we reach 2,4,6..
            if(s_map[c]%2 == 0)
                count += 2;
        }

        //if the length > count, that means we still have lone letters
        //thus count++
        if(s.length()-count)
            count++;
        return count;
    }
};

/* 
Approach 2
So any pair of letters is taken and added on either side of the mid line (imaginary) 
So everytime we see the letter and thats already present in the hashset, remove it from there and add 2 to the count 
at the end of it, if the hashset still has letter, we can pick any of them and add it to the middle point , thus count++
*/
class Solution {
public:
    int longestPalindrome(string s) {
        unordered_set<char> s_set;
        int count = 0;

        //create the hashset and remove the letter every time we've already seen it
        //for every pair, increase the count by 2
        for(char c: s){
            if(s_set.find(c) == s_set.end())
                s_set.insert(c);
            else {
                s_set.erase(c);
                count += 2;
            }
        }

        //if there are still letters in the hashset, there are lone letters 
        if(!s_set.empty())
            count++;
        return count;
    }
};