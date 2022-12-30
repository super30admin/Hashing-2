import java.util.HashSet;

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Approach: In this approach we use a hashset to store the characters of the string. If a char is present and we encounter another one
//we increment the count by 2 since it is pair and can be present in the longest palindrome. If the char is not present we add it to the 
//hashset and we move to the next one. If the set is not empty then it means there are characters of odd frequency present so we can add
//them at the middle of the palindrome and increment the count by 1.

class Solution {
    public int longestPalindrome(String s) {

        if(s.length() == 0 || s == null) return -1;
        if(s.length() ==1)return 1;

        HashSet<Character> set= new HashSet<>();

        int count =0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(set.contains(c) == true){
                count += 2;
                set.remove(c);
            }else{
                set.add(c);
            }
        }
        if(set.isEmpty() == false) return count+1;
        return count;
    }
}
