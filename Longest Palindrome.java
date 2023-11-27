// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map= new HashMap<>();
        int count=0;
        boolean flag= false;
        for(char c :s.toCharArray())
        {
            map.put(c,map.getOrDefault(c,0)+1);

        }

        for(char c: map.keySet())
        {
            int freq= map.get(c);
           
            if(freq%2==0)
            count=count+freq;

            else
            {
                count=count+(freq/2)*2;
                flag= true;
            }

            

        }
        if(flag)
          count++;
        
        return count;
    }
}