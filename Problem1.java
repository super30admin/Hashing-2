// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// we calculate running sum and store the count of each running sum in a hashmap.
// If the difference between the running sum and k exists in the hashmap, we add its count to our result.

import java.util.*;
public class Problem1{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++)
            nums[i]=sc.nextInt();

        int k=sc.nextInt();
        HashMap<Integer,Integer> mp=new HashMap<>();
        int rsum=0,count=0;
        mp.put(0,1);
        for(int i=0;i<nums.length;i++){
            rsum+=nums[i];
            int cmp=rsum-k;
            if(mp.containsKey(cmp))
                count+=mp.get(cmp);
            mp.put(rsum,mp.getOrDefault(rsum,0)+1);
        }
        System.out.println(count);
    }
}