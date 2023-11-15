import java.util.HashMap;
import java.util.HashSet;

// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class LongestPalindrome {
//    public int longestPalindrome(String s) {
//        int count = 0;
//        Map<Character,Integer> map = new HashMap<>();
//        for(char c: s.toCharArray())
//            map.put(c,map.getOrDefault(c,0)+1);
//        boolean flag = false;
//        for(int i : map.values()){
//            count += (i/2)*2;
//            if(i%2==1)
//                flag = true;
//        }
//        if(flag)
//            count = count +1;
//        return count;
//    }
    public int longestPalindrome(String s) {
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for(char c: s.toCharArray()){
            if(set.contains(c)){
                count+=2;
                set.remove(c);
            }else{
                set.add(c);
            }
        }
        if(!set.isEmpty())
            count++;
        return count;

    }
    public int longestPalindrome2(String s) {
        int count = 0;
        boolean[] set = new boolean[58];//to consider all characters
        for(char c: s.toCharArray()){
            if(set[c-'A']){
                count+=2;
                set[c-'A'] = false;
            }else{
                set[c-'A'] = true;
            }
        }
        for(int i= 0; i < set.length; i++){
            if(set[i]){
                count++;
                break;
            }
        }
        return count;

    }
}
