
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// if ele is in set remove it and add 2 to count
// else add it to set if still present in set then add 1 to count

import java.util.*;
public class Problem3{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        HashSet<Character> set=new HashSet<>();
        int count=0;
        for(char c:s.toCharArray()){
            if(set.contains(c)){
                set.remove(c);
                count+=2;
            }else
                set.add(c);
        }
        if(set.size()>0)
            System.out.println(count+1);
        else
            System.out.println(count);
    }
}