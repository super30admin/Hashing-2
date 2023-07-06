import java.util.HashSet;

class longestPalindrome {
    public int longestPalindrome(String s) {
        if( null == s || s.isEmpty()) return 0;
        HashSet<Character> palCheck = new HashSet<>();
        int maxLengthOfPalindrome = 0;
        for(Character charInS: s.toCharArray()){
            if(palCheck.contains(charInS)){
                maxLengthOfPalindrome += 2;
                palCheck.remove(charInS);
            }else{
                palCheck.add(charInS);
            }
        }
        if(palCheck.size() > 0){
            maxLengthOfPalindrome += 1;
        }

        return maxLengthOfPalindrome;
    }
}