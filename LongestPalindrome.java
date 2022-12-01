// Time Complexity : O(n)
// Space Complexity : O(1)

/*
 * Create hashmap to store the sting elements if they occur more than once 
 * remove it and increment the count by 2 and if the hashmap is not empty 
 * at the end then increment count by 1.
 */

import java.util.HashMap;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashMap <Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, 1);
            }
            else{
                res += 2;
                map.remove(c);
            }
        }
        if(map.size() != 0){
            res += 1;
        }
        return res;
    }
}
