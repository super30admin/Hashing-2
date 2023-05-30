import java.util.HashMap;

// Time Complexity : O(n) where n is the length of the input string
// Space Complexity : O(1), even though we're using a HashMap, it will be of almost a constant size (max 52) as there are only a-z and A-Z in the input
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

class LongestPalindrome
{
    public LongestPalindrome()
    {

    }

    public int longestPalindrome(String s)
    {
        int longestPalindromLen = 0;
        if( s== null || s.length() < 1)
        {
            return 0;
        }
        if(s.length() == 1)
        {
            return 1;
        }

        //first create a hashMap of alphabets
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for(Integer i =0; i< s.length(); i++)
        {
            Integer key = Integer.valueOf(s.charAt(i));
            if(!frequencyMap.containsKey(key))
            {
                frequencyMap.put(key, 0);
            }

            Integer count = frequencyMap.get(key);
            frequencyMap.put(key, count+1);
        }

        boolean hasOne = false;
        boolean hasOdd = false;

        for(Integer value : frequencyMap.values())
        {
            if(value == 1)
            {
                hasOne = true;
                continue;
            }
            if(value % 2 != 0)
            {
                hasOdd = true;
                value = value -1;
            }
            longestPalindromLen = longestPalindromLen + value;
        }

        //now if there was at least one alphabet that occurred once
        //it can be at the centre of the palindrome
        if(hasOdd)
        {
            longestPalindromLen++;
        }
        if(hasOne && longestPalindromLen % 2 == 0)
        {
            longestPalindromLen++;
        }

        return longestPalindromLen;
    }

    public static void main(String[] args)
    {
        String input = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometode" +
                "dicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirli" +
                "vesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisground" +
                "ThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayhere" +
                "butitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisr" +
                "atherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeas" +
                "ureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanew" +
                "birthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        LongestPalindrome obj = new LongestPalindrome();
        System.out.println(obj.longestPalindrome(input));

    }
}