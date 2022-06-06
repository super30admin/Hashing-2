public class SubArraySumK {
    // TC is O(n)
    // SC is O(n)
        public int subarraySum(int[] nums, int k) {
            int n = nums.length;
            int rSum = 0;
            int occurence = 0;
            Map<Integer, Integer> rMap = new HashMap<>();
            rMap.put(0,1);
            for(int i=0; i<n;i++){
                rSum += nums[i];
                if(rMap.containsKey(rSum-k)){
                    occurence += rMap.get(rSum-k);
                }
                if(rMap.containsKey(rSum))
                    rMap.put(rSum,rMap.get(rSum)+1);
                else
                    rMap.put(rSum,1);
            }
            return occurence;
        }
}
