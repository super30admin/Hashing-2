// Time Complexity :
//      n - size of string
//      longestPalindrome() - O(n)
//      
// Space Complexity :
//      longestPalindrome() - O(1)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Problem3 {
	public int longestPalindrome(String s) {
        //edge case
        if(s == null || s.length() == 0)
            return 0;
        else if(s.length() == 1)
            return 1;
        else
        {
            HashMap<Character, Integer> mp = new HashMap<>();
        
            for(int i=0; i < s.length(); ++i)
            {
                if(mp.get(s.charAt(i)) == null)
                    mp.put(s.charAt(i), 1);
                else
                    mp.put(s.charAt(i), mp.get(s.charAt(i))+1);
            }

            int sum = 0;

            boolean flag = false;

            for(int val : mp.values())
            {
                if(val % 2 == 1)
                {
                    if(flag == false)
                    {
                        sum += val;
                        flag = true;
                    }
                    else
                    {
                        sum += (val-1);
                    }
                }
                else
                {
                    sum += val;
                }   
            }

            return sum;
        }
    }
}