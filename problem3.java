// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// We use a set to count even count elements. so first we insert into set and when it occurs second time , we increment count+=2 and remove from set.
// at last , if the set is not empty, that means there is atleast one odd count character, so we add one to count.

class Solution {
    public int longestPalindrome(String s) {
        if(s.length()==0) return 0;
        HashSet<Character>set = new HashSet<>();
        int count =0;
        for(int i=0;i<s.length();i++)
        {
            char ele = s.charAt(i);
            if(set.contains(ele))
            {
                count+=2;
                set.remove(ele);
            }
            else{
                set.add(ele);
            }
        }
        if(!set.isEmpty())
        {
            count+=1;
        }
        return count;
    }
}