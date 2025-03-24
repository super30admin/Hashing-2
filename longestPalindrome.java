import java.util.HashSet;

class Solution {
    public int longestPalindrome(String s) {



        HashSet<Character> set = new HashSet<>();
        int count = 0;

        for(char c : s.toCharArray())
        {
            if(set.contains(c))
            {
                count += 2;
                set.remove(c);
            }
            else
            {
                set.add(c);
            }
        }

    if(set.size() > 0 ) return count+1;
    return count;
















    //     HashMap<Character,Integer> map = new HashMap<>();

    //     for(char c : s.toCharArray())
    //     {
    //         // if(map.containsKey(c))
    //         // {
    //         //     map.put(c,map.get(c)+1);
    //         // }
    //         // else
    //         // {
    //         //     map.put(c,1);
    //         // }

    //         map.put(c,map.getOrDefault(c,0)+1);
    //     }

    //     int count = 0;
    //     boolean flag = false;
    //     for(char c : map.keySet())
    //     {
    //         int frq = map.get(c);
    //         if(frq % 2 == 0 )
    //         {
    //             count = count + frq;
    //         }
    //         else
    //         {
    //             count += frq - 1;
    //             flag = true;
    //         }
    //     }

    //     if(flag) return count+1;
    //     return count;
    // }

}
}