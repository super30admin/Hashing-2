//TimeComplexity:O(n)


class Solution {
    public int longestPalindrome(String s) {
        int count =0;
        HashSet<Character> myset = new HashSet<>();
        for(int i =0; i<s.length();i++) {
            if(!myset.contains(s.charAt(i))) {
                 myset.add(s.charAt(i));
            } else {
                myset.remove(s.charAt(i));
                count = count+2;
            }
        } 
        if(!myset.isEmpty()) {
            count = count+1;
        }
        return count;
    }
}
