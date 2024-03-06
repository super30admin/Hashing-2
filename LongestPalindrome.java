import java.util.HashSet;
// tc= o(n)
//sc = o(n)
class Solution {
    public int longestPalindrome(String s) {
        int count = 0;
        if(s.length()==0 || s == null){
            return count;
        }
        HashSet<Character> set = new HashSet<>();
        for(char c:s.toCharArray()){
            if(set.contains(c)){
                count = count + 2;
                set.remove(c);
            }
            else{
                set.add(c);
            }
        }
        if(!set.isEmpty()){
            count = count + 1;
        }
        return count;
    }
}
