// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Iterate over the string and count each char apperance
//if a char is having even number that can be uased to create a palindrome
//for odd number characters,the floor even number can be taken to construct the palindrome
//out of remaining odd chars if exists one can be put in middle for the palindrome
class LongestPalindrome {
    public int longestPalindrome(String s) {
        int palindromeLen = 0;
        char[] arr = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        //create char count
        for(char ch : arr)
        {
            int currCount = map.getOrDefault(ch,0);
            map.put(ch,currCount+1);
        }
        boolean oddCountExists = false;
        for(Map.Entry<Character,Integer> entrySet : map.entrySet())
        {
            int count = entrySet.getValue();
            //even count char
            //add all to palindrome
            if(count%2==0)
            {
                palindromeLen+=count;
            }
            //if odd len is 1, it will add 0 to palindromeLen,
            //oddCountExists true to put any one odd char in palindrome
            else
            {
                palindromeLen+=(count-1);
                oddCountExists=true;
            }

        }
        return (oddCountExists)?(palindromeLen+1):palindromeLen;
    }
}