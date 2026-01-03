import java.util.*;

class Solution {
    public int longestPalindrome(String s) {

        HashSet<Character> set=new HashSet<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            //if hashset contains the ch already then increase the count variable by 2
            if(set.contains(ch)){
                count+=2;
                //after count going to even number, remove from set
                set.remove(ch);
            }
            //if set does not have that character then add it
            else{
                set.add(ch);
            }
        //If set is not empty, increase the count variable by 1    
        }if(!set.isEmpty()){
            count++;
        }
        //at the end return the value of count variable
        return count;
    }
}