// This algorithm tracks the running count and increments it for every character reaching 2. This will ensure all the even counted characters will be accounted for. For odd occurences, we maintain a set to add when count is odd and remove when it is even. At the end, if someting is left that specifies the odd occurence count is available and we increment total count by 1
class Solution {
    public int longestPalindrome(String s) {
        Set<Character> oddOccurenceSet = new HashSet();
        boolean[] charCount = new boolean[65];
        int palindromeCount = 0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(!charCount[c-'A']) {charCount[c-'A']=true; oddOccurenceSet.add(c); continue;}
            else {
                charCount[c-'A']=false;
                oddOccurenceSet.remove(c);
                palindromeCount+=2;
            }
        }
        if(oddOccurenceSet.isEmpty()) return palindromeCount;
        return palindromeCount+1;
    }
}
