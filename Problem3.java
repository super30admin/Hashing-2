//409 Longest Palindrome
//solved successfully on leetcode and faced no issues
//TC:O(n) SC:O(n)


class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character>palin = new HashSet<>();  //initialised a hashset for characters in given string
        int result = 0;
        //add a string to the Hashset and if you find the same string again while iterating , double the count & remove the string from Hashset. If string is already present in the Hashset,add string to it.
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(palin.contains(ch)){
                result +=2;
                palin.remove(ch);
             }
            else{
                palin.add(ch);
            }
        }
        //If Hashset is empty , return the result. If not empty , add 1 to result as u can put the left out string in middle.
        if(palin.isEmpty()){  
            return result;
        }
        else{
            return result+1;
        }
    }
}