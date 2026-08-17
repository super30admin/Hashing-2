class Solution {
    public int longestPalindrome(String s) {
        int len = 0;
        HashSet<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        for(Character str: arr) {
            if(set.contains(str)) {
                len = len +2;
                set.remove(str);
            } else {
                set.add(str);
            }
        }

        if(set.isEmpty()) {
        return len ;
        } else {
            return len+1;
        }
    }
}