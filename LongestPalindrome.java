// Time Complexity : O(N) where N is the length of the string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach 1:
// The approach involves using a frequency array to count occurrences of each character.
// Then, we sum up even counts and the largest possible odd count to form the longest palindrome.

class LongestPalindrome {
    public int longestPalindrome(String s) 
    {
        char[] ch = s.toCharArray();
        int[] c = new int[58];
        for(int i =0;i<ch.length;i++)
        {
            int j = ch[i]-'A';
            c[j] = c[j]+1;
        }
        boolean b = false;
        int op = 0;
        for(int i =0;i<c.length;i++)
        {
            if(c[i]%2 == 1)
            {
                op=op+c[i]-1;
                b=true;
            }
            else
            {
                op=op+c[i];
            }
        }
        if(b)
        {
            return op+1;
        }
        return op;    
    }
}

// Time Complexity : O(N) where N is the length of the string
// Space Complexity : O(1) (at most 52 entries in the HashMap for uppercase and lowercase letters)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach 2:
// The approach uses a HashMap to count character frequencies.
// We sum up even counts and the largest possible odd count to maximize palindrome length.

/*
class Solution {
    public int longestPalindrome(String s) 
    {
        HashMap<Character,Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            if(map.containsKey(ch[i]))
            {
                int get = map.get(ch[i]);
                map.put(ch[i],get+1);
            }
            else
            {
                map.put(ch[i],1);
            }
        } 
        boolean odd = false; 
        int op = 0;
        for(Map.Entry<Character,Integer> m:map.entrySet())
        {
            if(m.getValue()%2==1)
            {
                op = op+m.getValue()-1;
                odd = true;
            }
            else
            {
                op = op+m.getValue();
            }
            //System.out.println(m.getValue());
        }  
        if(!odd)
        {
            return op;
        }
        return op+1;
    }
}
*/