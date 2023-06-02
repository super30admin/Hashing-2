package Hashing2;

import java.util.HashMap;
/*
 *Here we use the running sum pattern and create an array where each index will store the summation of elements
 *from nums[ ] till that index. We also maintain a hashmap with ContinousSum mapped to no of occurrences. The condition
 *we check is if currentContinousSum - target= prevContinousSum and we search prevContinousSum in the map and increment count by its occurrence.
 *
 * 
 * Time Complexity :
 * O(n) where n is the no of elements 
 *  
 * 
 * Space Complexity :
 * Space complexity is O(n) as we use a map and insert each currentSum and occurrence into it.
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 * 
 */

public class Problem1 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(0,1);
        int[] continousSum = new int[nums.length];
        continousSum[0]=nums[0];
        int count=0;


        for(int i=0;i<nums.length;i++){

            if(i>0){
                continousSum[i]=continousSum[i-1]+nums[i];
            }

            int mapKey= continousSum[i]-k;


            if(map.containsKey(mapKey)){
                count=count+map.get(mapKey);
            }
            if(!map.containsKey(continousSum[i]))
                map.put(continousSum[i],1);
            else{
                map.put(continousSum[i],map.get(continousSum[i])+1);
            }

        }

        return count;
    }
}
