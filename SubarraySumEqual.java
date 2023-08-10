// Time Complexity : o(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

class SubarraySumEqual{
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int rsum = 0;
        map.put(0,1); // we are adding dumy value to to avoid missing gap.
        for(int i=0; i<nums.length; i++){
            rsum = rsum + nums[i]; // Calculating running sum with array numbers.
            int comp = rsum - k; // Get the complement.
            if(map.containsKey(comp)){ // Checking if the complement present in the map if yes then increase the count.
                count = count + map.get(comp); 
            }if (map.containsKey(rsum)){  // If running sum is present in the map then increase the count by 1.
                map.put(rsum, map.get(rsum)+1);
            }else{
                map.put(rsum,,1);
            }
        }
        return count;
    }
}