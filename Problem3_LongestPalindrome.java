import java.util.HashSet;

//Use a Hashset to store the chars in the String S 
//Remove the character from the set once a pair of the same char is found
//For each pair of the same char found increase the count by 2
//At the end the set can be empty the return count
//or the set can contain the characters with odd number occurances in the string, then return count by incrementing with 1

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes

class Problem3_LongestPalindrome {
    public int longestPalindrome(String s) {
        int count=0;
        if(s==null || s.length()==1) return s.length();
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(set.contains(c)){
                count+=2;
                set.remove(c);
            }else{
                set.add(c);
            }
        }
        return !set.isEmpty()? ++count:count;
    }
}