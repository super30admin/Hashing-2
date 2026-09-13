/*Time Complexity :O(N)-> N  total numbers length
Space Complexity : O(N)

Did this code successfully run on Leetcode :Yes
Any problem you faced while coding this :No */
class SubArraySumK {
    public int subarraySum(int[] nums, int k) {
        /*y-x= z . y(rsum), x(k)
        rsum- k =z
        z= rsum-k;
        find such z and how many times it has happened.*/

        int rSum = 0;
        int totalSubArrays = 0;
        //runningsum, how many times
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            rSum = rSum + nums[i];
            // this is based on y-x =z==> z= y-x
            int rSumComplement = rSum - k;

            //Is there any rSumComplement available in the map and how many times
            if (map.containsKey(rSumComplement)) {
                totalSubArrays = totalSubArrays + map.get(rSumComplement);
            }
            if (!map.containsKey(rSum)) {
                map.put(rSum, 0);
            }
            map.put(rSum, map.get(rSum) + 1);

        }
        return totalSubArrays;
    }
}