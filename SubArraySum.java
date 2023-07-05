class SubArraySum {
 /* Time Complexity - O(n)
     Space Complexity- O(n)
     The diff in runningSum between two indexes  = 7 is the subarray sum. Count all such occurences.
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int rSum = 0;
        int count = 0;
        for (int i=0; i< nums.length; i++) {
            rSum += nums[i];
            int compliment = rSum -k;
            if (map.containsKey(compliment)) {
                count = count + map.get(compliment);
            } 
            map.put(rSum, map.getOrDefault(rSum, 0)+ 1);
        }
        return count;
    }
}