// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int rsum = 0;
        int max = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,-1);
        
        //Maintain running sum
        for(int i = 0; i < nums.length; i++){
            if(nums[i]==0){
                rsum+=-1;
            }else if(nums[i]==1){
                rsum+=1;
            }
            if(hm.containsKey(rsum)){ // check if running sum occured before, if so we know that it is contiguous between those indexes. Compare the length and store in max
                max = Math.max(i-hm.get(rsum), max);
            }else{
                hm.put(rsum,i);
            }
        }
        return max;
    }
}
