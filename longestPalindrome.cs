//Time and space - O(n)

// Use a HashSet to track characters that appear an odd number of times.
// When a character appears twice, form a pair, add 2 to the palindrome length, and remove it from the set.
// After processing all characters, if any odd-count character remains, add 1 to place one in the center
public class Solution
{
    public int LongestPalindrome(string s)
    {
        HashSet<char> hash = new();
        int count = 0;
        for (int i = 0; i < s.Length; i++)
        {
            char ch = s[i];
            if (hash.Contains(ch))
            {
                count += 2;
                hash.Remove(ch);
            }
            else
            {
                hash.Add(ch);
            }
        }
        if (hash.Count != 0)
        {
            count += 1;
        }
        return count;
    }
}

