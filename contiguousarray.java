// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> hashMap=new HashMap<>();
        
        int max=0;
        int currentsum=0;
        hashMap.put(0,-1);
        
        for(int x=0; x<nums.length; x++){
            if(nums[x]==0){
                currentsum +=1;
            }else{
                currentsum -=1;
            }
            if(hashMap.containsKey(currentsum)){
                int end=x;
                int start= hashMap.get(currentsum);
                max=Math.max(max, end-start);
            }else{
                hashMap.put(currentsum,x);
            }
        }
        return max;
    }
}