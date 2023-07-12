class Solution {
    public int longestPalindrome(String s) {
        int count=0;
        HashSet<Character> hs=new HashSet<>();
        
        for(int i=0;i<s.length(); i++)
        {
            char c=s.charAt(i);

            if(hs.contains(c))
            {
                count+=2;
                hs.remove(c);
            }
            else{
                hs.add(c);
            }
        }
        if(hs.isEmpty()!=true) {
            count++;
        }
        return count;
    }
}