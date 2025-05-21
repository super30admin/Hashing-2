/*
  Time complexity: O(n)
  Space complexity: O(1)

  Code ran successfully on Leetcode: Yes

  Approach: The characters are added on their odd occurrence and removed on even number occurrence from the HashSet. Count is also increased by 2. In the end, if hashset is not empty, count is incremented by 1 to account for the middle element in which case the palindrome will have odd number of elements.

*/


public class Solution {
    public int LongestPalindrome(string s) {
    int count = 0;
    HashSet<char> set = new HashSet<char>();
    foreach (char c in s)
    {
        if (set.Contains(c))
        {
            count+=2;
            set.Remove(c);
        }
        else
        {
            set.Add(c);
        }
    }
    if(set.Count>0)
        count++;
    
    return count;
    }
}
