class Solution01 {
    int count =0;
    public int subarraySum(int[] nums, int k) {
        for(int i= 0; i<nums.length; i++){
            if(nums[i]<=k){
                if(i>0 && nums[i]==nums[i-1]){
                    break;
                }
                if(nums[i]==k) count++;
                    for(int j=i+1; j<nums.length;j++){
                        if(nums[j]<=k){
                            if(nums[i]+nums[j]==k){
                                count ++;
                            }
                        }
                        }
            
          }
        }
    return count;
    }
}