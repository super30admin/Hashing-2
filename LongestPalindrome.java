class Solution {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0) return -1;
        boolean[] set = new boolean[60];
        int count =0;
        for(char c: s.toCharArray()){
            if(set[c-'A']){
                count+=2;
                set[c-'A'] = false;
            }else{
                set[c-'A'] = true;
            }
        }
        if(s.length()> count) return count+1;
        return count;
    }
}