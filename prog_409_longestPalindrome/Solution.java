package prog_409_longestPalindrome;

import java.util.HashSet;

public class Solution {
    /*
    In this problem, they have given us large string of repeated characters and we have to find the longest palindrome string we can form and return it's  length
    for eg: abccccdd string could b "ccdadcc" and length = 7
    The palindrome can be form with the pairs, all even number characters and 1 odd number character

    Approach 1 :
    We can keep a hashmap where we store each character and its frequency.
    Once we form a hashmap, we will be iterating through hashmap and get the even characters and increase the count.
    Since it is 2 pass algotithm we can use hashset

    Appraoch 2:
    In this approach we will use a hashset, we will b storing the characters
    1) If my character does not exist in hashset then i will simply add that character.
    2) If my character is already exist then to form a palindrome, we will remove that character from hashset and
       increase total count by 2.
    3) In palindrome, we can use 1 odd number character, so we will be checking if hashset is empty if not empty then
       we will increase total count by 1
    This will be our 1 pass algotithm.

    Time complexity: O(N)
    As we will b iterating through all characters

    Space complexity: O(1)
    we will storing only 26 chars even if we have string of length 1000
    so our space complexity is constant.

    Approach 3 :
    We can use the boolean array of 56 characters and set true, false based on the characters
    char c - 'a' = index and set the index in boolean array.
    */
    public int longestPalindrome(String s) {
        HashSet storage = new HashSet ();
        int totalCount = 0 ;
        for(int i = 0; i <= s.length()-1; i++){
            char c = s.charAt(i);
            if(storage.contains(c)){
                storage.remove(c) ;
                totalCount = totalCount + 2 ;
            }
            else{
                storage.add(c);
            }
        }
        if(!storage.isEmpty()){
            totalCount = totalCount + 1 ;
        }
        return totalCount ;
    }
}