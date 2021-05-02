// Time Complexity : O(n) as in order to add element to hashset we need to iterate n times
// Space Complexity : Maximum 52 characters has to be stored considering lower case and upper case letters
// Approach : Add element to HashSet when single occurence is found, for every multiple occurence remove element from hashset
// and increment count by 2
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class LongestPalindromeLength {
    public int longestPalindrome(String s) {
        if(s.length()==0 || s==null)
            return 0;
        int count=0;
        HashSet<Character> charSet = new HashSet<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!charSet.contains(c)) {
                charSet.add(c);
            } else {
                count+=2;
                charSet.remove(c);
            }
        }
        if(!charSet.isEmpty()) {
            count++;
        }
        return count;        
    }
}
