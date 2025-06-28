//Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
//Approach: count the frequency of each character using a hash map.Add all even counts directly, and for odd counts, we add the largest even number less than them ( freq - 1). If there’s at least one odd count, we can place one odd character in the center, so we add 1 to the total length.
import java.util.HashMap;
class Solution {
    public int longestPalindrome(String s) {

    HashMap<Character,Integer> map= new HashMap<>();

    for(int i=0;i<s.length();i++){
        char ch= s.charAt(i);
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

     int count = 0;
     Boolean hasOdd=false;

     for(int freq: map.values()){
        if (freq %2 ==0){
            count +=freq;
        }else{
            count += freq - 1; 
                hasOdd = true;
        }
     }
      if (hasOdd) {
            count += 1;
        
    }
    return count;
}
}