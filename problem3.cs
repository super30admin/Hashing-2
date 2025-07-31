public class Solution {
    public int LongestPalindrome(string s) {
        var palindromeHashSet = new HashSet<char>();
        var result = 0;
        foreach(var c in s)
        {
            if(palindromeHashSet.Contains(c))
            {
                result = result +2;
                palindromeHashSet.Remove(c);
            }
            else
            {
                palindromeHashSet.Add(c);
            }
        }
        if(palindromeHashSet.Count > 0)
        {
            result = result+1;
        }
        return result;
    }
}