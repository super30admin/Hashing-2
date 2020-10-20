//This problem was asked at Facebook
//LeetCode 409.

//Given a string consisting of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
//This is case sensitive, for example "Aa" is not considered a palindrome here.

//Example:
//Input:"abccccdd"
/Output:7


class Solution {
     public int longestPalindrome(String s) {

         Set<Character> set = new HashSet();
         for(char c: s.toCharArray()){
             if(set.contains(c)){
                 set.remove(c);
             }
             else{
                 set.add(c);
             }
         }
         System.out.println(set);
         if(set.size()<=1){
             return s.length();
         }
         else{
             return s.length()-set.size()+1;
         }
     }
 }