// space complexity 0(1)
// Time complexity 0(n)
class Solution {
    public int longestPalindrome(String s) {
        if(s.length()==0 || s==null)
            return 0;
        HashSet <Character> pal = new HashSet<>();
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(pal.contains(c))
            {
                count=count+2;
                pal.remove(c);
            }
            else
            {
                pal.add(c);
            }
        }
        if(!pal.isEmpty())
        {
            count++;
        }
        return count;
    }
}