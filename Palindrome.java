class Palindrome {
    public int longestPalindrome(String s) {
        int count=0;
        Set<Character> set = new HashSet<>();
        for(Character c:s.toCharArray()){
            if(set.contains(c)){
                count = count+2;
                set.remove(c);
            }
            else{
                set.add(c);
            }
        }
        if(set.size()>0){
            return count+1;
        }
        return count;
    }
}