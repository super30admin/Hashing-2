// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int cnt=0;
        int max=0, start=0, end=0;
        map.put(0,-1);
    
        for(int i=0;i<nums.length;i++){
            //everytime we encounter 0, we decrease 1 from running sum
            if(nums[i]==0) cnt-=1;
            //everytime we encounter 1, we increase 1 to running sum
            else cnt+=1;

            //if map does not contain the running sum value, add it
            if(!map.containsKey(cnt)){
                map.put(cnt, i);
            }else{
                //if map conatins the running sum value, get the value , and check if
                //the length of the array of from stored index to current index is greater than max
                //if yes then update it , we have maintained the end ans start ptrs to print the array
                if(max<i - map.get(cnt)){
                    max=  i - map.get(cnt);
                    start=map.get(cnt)+1;
                    end=i;
                }
                
            }
        }
        
        for(int i=0;i<=end;i++){
            System.out.println(nums[i]);
        }
        return max;
    }
}