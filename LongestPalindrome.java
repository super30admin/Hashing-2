class LongestPalindrome {
    public int longestPalindrome(String input) {
        int result=0;
        HashSet<Character> set = new HashSet();
        for(int i=0;i<input.length();i++){
            Character ch = input.charAt(i);
            
            if(set.contains(ch)){
                set.remove(ch);
                result+=2;
            }else{
                set.add(ch);
            }
        }
        
        if(!set.isEmpty()) result++;
        return result;
    }
}