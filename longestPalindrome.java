/*
Algorithm

1. Count the frequency of each character in the string.
2. For each character frequency:
    -If the frequency is even, all of it can be used in the palindrome.
    -If the frequency is odd , use (freq-1) characters (the even part),
    and mark that we have at least one odd character available.
3. If atleaset one odd character, we can place it in the center of the palindrome, so we can add 2 to the result.
4. Return the total length of the longest palindrome.


*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestPalindrome(String s) {
        //Step1 : Create a map to store the frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();

        //Count the frequency of all characters
        for(char c : s.toCharArray()){
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0)+1);
        }
         int length=0; //Final result: length of the longest longestPalindrome
         boolean hasOddFrequency = false; //Flag to track if any odd frequency exists

         //Steps 2: Process each character's frequency
         for(int freq: frequencyMap.values()){
            if (freq % 2 == 0){
                length += freq; //use all even frequencies
            } else{
                length += freq-1; //Use even part oif the odd frequency
                hasOddFrequency = true; //One odd character can go in the center
            }
         }
        

        //Step3: If there is an odd frequency character, add 1 to center placement
        if(hasOddFrequency){
            length+=1;
        }

        //Step4: Return the total length of the paloindrome
        return length;
    }
}