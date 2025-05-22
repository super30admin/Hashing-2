//time: O(n)
//Space:O(1)
// create a set of char if the char is present, add in result +2 and remove the char as we already found the pair. If its occuring for the first time add in th set and in last if set is not empty then add +1 as we can have a Palindrome with odd length
class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character>sh = new HashSet<>();
        int result=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(sh.contains(ch)){
                result= result+2;
                sh.remove(ch);
            }
            else{
                sh.add(ch);
            }

        }
        if(!sh.isEmpty()){
            result= result+1;
        }
        return result;
    }
}