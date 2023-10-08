import java.util.HashSet;

// to build a palindrome we need a pair of all characters and one odd character
// to do that, we will first want to store the character in hashset
// if it's pair exsists, then we update the value of count by two and remove the character
// in the end, if the hashset is not empty we increment the count and return the result

public class LongestPalindrome {
    

    public static void main(String[] args)
    {
        String s = "aabbccbbbddaeeessfg";
        System.out.println("Longest Palindrome length " + LongestPalindrome(s));
    }

    //Time Complexity : O(n)
    //Space Complexity : O(1)
    public static int LongestPalindrome(String s)
    {
        HashSet<Character> set = new HashSet<>();
        int count = 0;

        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(set.contains(c)){
                count +=2;
                set.remove(c);
            }
            else
            {
                set.add(c);
            }
        }

        if(!set.isEmpty()) count++;
        return count;

    }

}
