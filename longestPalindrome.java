//We maintain a set and add char to it.
//if char already present then count + 2 and remove that char



class Solution {
    public int longestPalindrome(String s) {
        if(s.length() ==1)return 1;
        int count = 0;
        char[] charArray = s.toCharArray();
        HashSet<Character> hashSet = new HashSet<>();
        for(int i=0;i<charArray.length;i++)
        {
            if(hashSet.contains(charArray[i]))
            {
                count += 2;
                hashSet.remove(charArray[i]);
            }
            else {
                hashSet.add(charArray[i]);
            }


        }
        if(!hashSet.isEmpty())
        {
            count += 1;

        }
        return count;
    }
}