
import java.util.HashSet;
import java.util.Set;
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on LeetCode : Yes
// Any problem you faced while coding this : No


//Approach - Use a HashSet and check, for each char in String s, check if set contains that charcter, add 2 to counter and
// remove that character from the set.
// if it is not there add the character to it.  Finally if set is not empty then increment counter with one and return the coouter
// You can use a boolean array of size 58 and apply the same approach as above.
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int counter =0;
        int strSize = s.length();
        for(int i =0; i < strSize; i++){
          char c =  s.charAt(i);
            if(set.contains(c)){
                counter += 2;
                set.remove(c);
            }else{
                set.add(c);
            }
        }
      if(!set.isEmpty()) counter++;
      return counter;
    }
    public int longestPalindromeUsingArray(String s) {
        boolean[] array = new boolean[58];
        int counter =0;
        int strSize = s.length();
        int arrLength = array.length;
        for(int i =0; i < strSize; i++){
            char c =  s.charAt(i);
            if(array[c - 'A']){
                counter += 2;
                array[c - 'A'] = false;
            }else{
                array[c - 'A'] = true;
            }
        }
        for(int j =0; j<arrLength; j++){
            if(array[j]){
                counter++;
                break;
            }
        }
        return counter;
    }
}
