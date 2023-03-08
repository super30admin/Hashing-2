class LongestPalindrome {
    public int longestPalindrome(String s) {
        int count = 0;
        HashSet<Character> hs = new HashSet<Character>();
        if(s.length()==1) return 1;
        for(int i = 0; i < s.length(); i++){
            if(hs.contains(s.charAt(i))){
                count+=2;
                hs.remove(s.charAt(i));
            }
            else
                hs.add(s.charAt(i));
        }
        if(!hs.isEmpty()){
            count++;
        }
        return count;
    }
}
