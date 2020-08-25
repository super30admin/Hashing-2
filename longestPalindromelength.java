class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set=new HashSet();
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(set.contains(s.charAt(i)))
            {
                count=count+2;
                set.remove(s.charAt(i));
            }
            else{
                set.add(s.charAt(i));
            }
        }
        if(set.size()>0)
        {
            return count+1;
        }
        return count;
    }
}

//Time Complexity-O(n)
//Space Complexity-O(n)