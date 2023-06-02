package Hashing2;

import java.util.HashMap;
/*
 *Here we use the running sum pattern and create an array where each index will store the summation of elements
 *from nums[ ] till that index(if 0 we subtract 1 and if 1 we add 1). We also maintain a hashmap with first occurence of each continousSum element with the index. 
 *The condition we check is if currentContinousSum is in the map and and if present we update length in case (currentContinousSum index - index retrieved from map) > length
 *
 * 
 * Time Complexity :
 * O(n) where n is the no of elements 
 *  
 * 
 * Space Complexity :
 * Space complexity is O(n)
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 * 
 */

public class Problem2 {
    public int findMaxLength(int[] nums) {
        int length=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);

        int continousSum[]=new int[nums.length];
        continousSum[0]= (nums[0]==0) ? -1 : 1;

        for(int i=0;i<nums.length;i++){
            if(i>0){
                if(nums[i]==0)
                    continousSum[i]=continousSum[i-1]-1;
                else
                    continousSum[i]=continousSum[i-1]+1;
            }

                    System.out.println(continousSum[i]);

            
            if(map.containsKey(continousSum[i])){
                if(i-map.get(continousSum[i])>length)
                    length=i-map.get(continousSum[i]);
            }
            else{
                map.put(continousSum[i],i);
            }
        }
        System.out.println(map);
        return length;
    }
}
