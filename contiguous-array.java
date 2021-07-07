// Time Complexity : O(N)    //because itirating through all characters to check
// Space Complexity :O(N)    //because using extra memory, worst case there could be n-elements not contiguous 
// Did this code successfully run on Leetcode :   yes


// Your code here along with comments explaining your approach

import java.util.*;
class Main {
  public static int contiguousArray(int []nums){
    if(nums==null || nums.length==0){
      return 0;
    }
    HashMap<Integer, Integer> map= new HashMap<>();
    int max=0; int rsum=0; int current=0;
    map.put(0, -1);
    for(int i=0; i<nums.length; i++){
      rsum=nums[i]==0 ? rsum-1 : rsum+1;
      if(map.containsKey(rsum)){
        current = i - map.get(rsum);
        max = Math.max(current, max);
      }else{
        map.put(rsum, i);
      } 
    }
    return max;
  }
  public static void main(String[] args) {
    int []nums={1,0,1,0,1,1,1,1,0,0,1,0,1};
    System.out.println("Contiguous subarray size is: " +contiguousArray(nums));
  }
}