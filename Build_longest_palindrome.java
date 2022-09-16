class Solution {
    public int longestPalindrome(String s) {
        
        if (s == null)
            return 0;
            
        HashSet<Character> hset = new HashSet<>();
        int result = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(hset.contains(s.charAt(i))) {
                result = result + 2;
                hset.remove(s.charAt(i));
            }
            else
                hset.add(s.charAt(i));
        }
        if(hset.size()>0)
            result++;
        
        return result;
    }
}


