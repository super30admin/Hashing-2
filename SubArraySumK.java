// Time Complexity : O(N) -- as traversing the array once
/* Space Complexity : O(N) -- as in worst case need to store N elements in
HashMap e.g. {1,1,1,1,1,1,1.....N times} or {0,0,0,0,0,0,0,0......N times}
*/ 
// Did this code successfully run on Leetcode : Yes
/* Any problem you faced while coding this : Had to go through the logic 
again which was discussed in class*/


// Your code here along with comments explaining your approach

import java.util.*;
class Solution {
    public int subarraySum(int[] nums, int k) {
        //(rSum,Frequency) stored
        HashMap<Integer,Integer> map = new HashMap<>(); 
        map.put(0,1);
        /*here target means the running sum of subarray is k
         * and count is to count how many times we find a subarray 
         * having target sum
        */
        int rSum = 0; int count = 0; int target = k;
        for(int i=0;i<nums.length;i++){
            rSum = rSum + nums[i];
            if(map.containsKey(rSum-target)){
                count = count + map.get(rSum-target);    
            }
            /* Incrementing the frequency count by 1 */
            if(map.containsKey(rSum)){
                map.put(rSum,map.get(rSum)+1);
            }else{
                map.put(rSum,1);
            }
        }
        return count;
    }
}


// ////////////////////////////////
// Brute Force way to find all the possible subarrays given an array
// ///////////////////////////////
/* 

class Solution {
    public int printSubArray(int[] nums) {
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            
            for(int j=nums.length-1;j>=i;j--){
                int[] temp = new int[j-i+1];
                System.arraycopy(nums,i,temp,0,j-i+1);
                arr.add(temp);

            }
            
        }
        for(int m=0;m<arr.size();m++){
            System.out.println(Arrays.toString(arr.get(m)));
        }
        
        return 3535;
    }
}

*/