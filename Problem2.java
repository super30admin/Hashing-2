// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// we calculate runnuning sum if ele is 0 rsum-- else rsum++
//if rsum contains in map we get the length and find maximum
//else we all the ele and the index in the map

import java.util.*;
public class Problem2{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++)
            nums[i]=sc.nextInt();
        HashMap<Integer,Integer> mp=new HashMap<>();
        mp.put(0,-1);
        int rsum=0,max=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0) rsum--;
            else rsum++;
            if(mp.containsKey(rsum))
                max=Math.max(max,i-mp.get(rsum));
            else
                mp.put(rsum,i);
        }
        System.out.println(max);
    }
}