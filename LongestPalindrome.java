class Solution {
    // Using a HashSet to maintain visited chars. If visited twice, increment res by 2 and remove the char from the set. At last if Set is not empty increment res by 1 and return otherwise return res.
    //TC -> O(N), where N is the length of the String
    //SC -> O(N), where N is length of String, and used for HashSet
    public int longestPalindrome(String s) {
        if(s == null || s.length() ==0) return 0;
        Set<Character> charSet = new HashSet<>();
        int res=0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(charSet.contains(c)){
                res += 2;
                charSet.remove(c);
            }else
                charSet.add(c);
        }
        if(!charSet.isEmpty()) return res+1;
        return res;
    }
}
