public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                count+=2;
                set.remove(s.charAt(i));
            }else{
                set.add(s.charAt(i));
            }
        }
        if(!set.isEmpty()){
            count++;
        }
    return count;
    }
}

// TC - O(n)
// SC - O(1)
