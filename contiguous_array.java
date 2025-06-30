// We treat 0 as -1 and calculate the running sum (rsum) to track the difference between 0s and 1s.
// If the same rsum has been seen before, it means the subarray between previous index and current has equal 0s and 1s.
// We use a HashMap to store the first occurrence of each rsum and update the max length accordingly.

//Time Complexity (TC):** `O(n)` – We traverse the array once.
//Space Complexity (SC):** `O(n)` – In the worst case, we store up to `n` running sums in the HashMap.

class Solution {
    public int findMaxLength(int[] nums) {

        if(nums == null || nums.length == 0 || nums.length ==1)
        {
            return 0;
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int rsum = 0;
        int max = 0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                rsum = rsum-1;
            }
            else
            {
                rsum = rsum+1;
            }

            if(map.containsKey(rsum))
            {
                max = Math.max(max, i-map.get(rsum));
            }
            else
            {
                map.put(rsum, i);
            }
        }
        return max;
         
    }
}