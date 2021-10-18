/**
 * Leet Code 560
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> mapping = new HashMap<Integer,Integer>();
        
        int totalCount = 0;
        int[] rSum = computeRSum(nums);
        int currentDiff=0;
        // base case
        mapping.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
            currentDiff = rSum[i]-k;
            
            if (mapping.containsKey(currentDiff))
            {
                totalCount = totalCount + mapping.get(currentDiff);
            }
            //Insert into rSum and count of subarrays with rSum into hashmap
            if(!mapping.containsKey(rSum[i]))
            {
                mapping.put(rSum[i], 1);    
            }
            else
            {
                int value = mapping.get(rSum[i]);
                mapping.replace(rSum[i], value+1);
            }
        }
        return totalCount;
    }
    //Compute running sum
    private int[] computeRSum(int [] nums)
    {
        int[] rSum = new int[nums.length];
        rSum[0] = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            rSum[i]=rSum[i-1]+nums[i];
            System.out.println(rSum[i]);
        }
        for(int i=0;i<nums.length;i++)
        {
            System.out.println("rSum is :"+ rSum[i]);
        }
        return rSum;
    }
}