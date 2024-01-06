class Solution {
    public int longestPalindrome(String s) {
      //Tc: O(N) where n is length of string
      //Sc: O(N) The space required by hashset
       int cnt = 0;
        HashSet<Character> hset = new HashSet<>();
        for(int i = 0; i < s.length();i++)
        {
            char c = s.charAt(i);
            if(hset.contains(c))
            {
                cnt += 2;
                hset.remove(c);
            }
            else
            {
            hset.add(c);
            }
        }
        if(!hset.isEmpty()) return cnt+1;
        else return cnt;
    }
}
