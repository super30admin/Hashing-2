package Hashing2;

import java.util.HashSet;
/*
 *Here we maintain a hashset which will store the characters as it comes. When we encounter the same character
 *seconnd time we will remove it from the hashset and increment count by 2. If after doing this for all all characters
 *the hashset is not empty then we add 1 to count which will account of the middle character for the palindrome
 * 
 * Time Complexity :
 * O(n) where n is the no of characters 
 *  
 * 
 * Space Complexity :
 * Space complexity is O(1) as no of characters is a constant, so size of hashset will not change for large inputs
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 * 
 */

public class Problem3 {
    public int longestPalindrome(String s) {

        HashSet<Character> set=new HashSet<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            Character character = s.charAt(i);
            if(!set.contains(character))
                set.add(character);
            else{
                set.remove(character);
                count+=2;}
        }

        if(!set.isEmpty()){
            return ++count;
        }
        else 
            return count;
        
    }

}
