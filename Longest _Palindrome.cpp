// (Apporach 1)
// Time Complexity : O(N) + O(k) ~ O(N) + O(1) ~ O(N)
//                    N is number of characters in string
//                    K is number of entries in map as we are iterating over map
//                    K can be maximum 52 (26 lower and 26 upper character); therefore it can be considered as O(1)
// Space Complexity : O(K) ~ O(1)   (As per above explaination for K)

// (Apporach 2)
// Time Complexity : O(N)
// Space Complexity : O(K) ... K is elements in set

// (Apporach 3)
// Time Complexity : O(N)
// Space Complexity : O(58) ... K is size of boolean array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leetcode : https://leetcode.com/problems/longest-palindrome
Given a string s which consists of lowercase or uppercase letters, 
return the length of the longest palindrome that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
*/

/*
Approach 1 : Using HashMap 
Hashmap is used to store the freqency data for each character.
Array is iterated one character by character and number of occurances of character
is stored as value and character is used as a key.
Once frequncy map is created, all elements of map are iterated.
each pair is considered and added to the count.  (count += no. of occurances / 2* 2)
e.g. if a is occured 3 times then count = 3 / 2 * 2 = 2 (out of 3 only 2 are considered in palindrom)
    if b is occured 4 times then count = 4 / 2 * 2 = 2

If we have at least one odd number of occurance then count is increased by one at the end.
*/

class Solution {
public:
    int longestPalindrome(string s) {
        int count = 0;
        std::unordered_map<char, int>fMap;
        int size = s.size();
        for(int i = 0; i < size; i++){
            char ch = s.at(i);
            if(fMap.find(ch) == fMap.end()){
                fMap[ch] = 1;
            } else {
                fMap[ch] += 1;
            }
        }
        int oddFlag = 0;
        for (auto &pair : fMap){
            count += pair.second / 2 * 2;
            if(pair.second %2 == 1) {
                oddFlag = true;
            }
        }
        count += oddFlag ? 1 : 0;
        return count;
    }
};


/*
Approach 2 : Using Hashset
String is iterated one character at a time. 
If character is not present in set then it is inserted.
If character is already present in set that means we have found a pair; so count
value is increased by 2 and character is erased from the set.

At the end if set is not empty that means at ;east one character with odd occurance (or 1)
is present and count value is increased by 1.
*/

class Solution {
public:
    int longestPalindrome(string s) {
        int count = 0;
        std::unordered_set<char>cSet;

        int size = s.size();
        for(int i = 0; i < size; i++){
            int ch = s.at(i);
            if(cSet.find(ch) == cSet.end()){
                cSet.insert(ch);
            } else {
                count += 2;
                cSet.erase(ch);
            }
        }
        if (!cSet.empty()) count +=1;
        return count;
    }
};



/*
Approach 3 :
Boolean array is used as a hashmap to store occurances of character.
ASCII value for Uppercase is : 65 to 90
and for Lowercase : 97 to 122
Considering 65 to 122 range, we will need array of size 58 to have all characters.
'A' being first element, it is used to find out the index for the character in array.
*/

class Solution {
public:
    int longestPalindrome(string s) {
        int count = 0;
        bool arr[58] = {false};

        int size = s.size();
        for(int i = 0; i < size; i++){
            int ch = s.at(i);
            if(arr[ch - 'A']){
                count += 2;
                arr[ch - 'A'] = false;
            } else {
                arr[ch - 'A'] = true;
            }
        }
        for( auto i : arr){
            if (i) {
                count += 1;
                break;
            }
        }
            
        return count;
    }
};