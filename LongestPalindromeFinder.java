/*
Time complexity : O(n)
Space complexity: O(n)
Approach:
1) Convert the string to char array
2) Create a hash set, loop through the character array, and if
    character at an index is already in hash set it can be used in palindrome so,
     remove it and increase the length of palindrome by 2 else add element to hash set
3) If after looping the set contains elements then we can increase the counter by 1 as it can be placed in middle of palindrome
 */
import java.util.HashSet;

public class LongestPalindromeFinder {
        public int longestPalindrome(String s) {
            int count = 0;
            HashSet<Character> hashSet = new HashSet<>();
            // Loop through a character array
            for(char ch: s.toCharArray()){
                // If the element is present in hash set
                if(hashSet.contains(ch)){
                    // Remove element
                    hashSet.remove(ch);
                    // Increase the length of palindrome by 2
                    count+=2;
                }
                // Else add the element to set
                else hashSet.add(ch);
            }

            if (hashSet.size() == 0) return count;
            // Increase the counter of non empty set by 1 as any element can be taken and placed in the middle of palindrome
            else return count+1;

        }
    }

