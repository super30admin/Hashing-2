
class Solution {
    public int longestPalindrome(String s) {
        int res = 0;
        HashMap<Character,Integer> m = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++)
        {
            if(m.containsKey(s.charAt(i)))
            {
                m.remove(s.charAt(i));
                res = res+2;
            }
            else
            {
                m.put(s.charAt(i),1);
            }
        }
        if(m.size()>0)
        {
            return res+1;
        }
        return res;
    }
}