import java.util.HashSet;

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
To find the answer, we only need to know how many times a character has occurred twice
ie for every 2 characters, count is +2. We can check this think efficiently with hashset.
For every new character if it is present in hashset, remove it and increment counter by 2 or else just add it
At last if hashset has an element, then count is + 1.
* */
class LongestPalindrome {
    public int longestPalindrome(String s) {



        HashSet<Character> ans=new HashSet<>();
        int count=0;
        for(Character c: s.toCharArray())
        {
            if(ans.contains(c))
            {
                count+=2;
                ans.remove(c);
            }
            else
            {
                ans.add(c);
            }
        }
        if(ans.size()>0)
            return count+1;
        return count;
    }
}
