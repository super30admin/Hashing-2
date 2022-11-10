// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
import java.util.HashSet;

public class longestPalindrome {
    public int program(String s){
        //create a hashset to store each char of the string
        HashSet<Character> hs=new HashSet<>();
        int ans=0;
        for(char c:s.toCharArray()){
            //if the hashset does not contain the character add it 
            if(!hs.contains(c)){
                hs.add(c);
            }
            //if the hashset contains the character it means that this is the second occurance 
            //so delete the char and inc the length by 2 
            else{
                ans+=2;
                hs.remove(c);
        }
        }
          
        //if hashset is not empty means that there is some char which occured only once
        //so it can be counted as the middle element of palindrome hence inc the count by 1 
        return hs.isEmpty()? ans : ans+1;
    }
}
