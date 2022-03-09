// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int rsum = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1); //base case i.e. 0 running sum always occurs once
        int count = 0;
        int tmp = -1;
        
        //Maintain running sum frequency, if ever running sum - k was found in hashmap add that to count
        for(int i = 0; i < nums.length; i ++){
            rsum += nums[i];
            
            if(hm.containsKey(rsum-k)){
                count+=hm.get(rsum-k);
            }
            
            
            if(hm.containsKey(rsum)){
                tmp = hm.get(rsum);
                hm.put(rsum,tmp+1);
            }else{
                hm.put(rsum,1);
            }
        }
        
        return count;
    }
}
