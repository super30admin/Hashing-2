//Time complexity: O(n)
//Space Complexity: O(n)
class SubArraySum {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int rSum=0;
        int res = 0;
        map.put(0,1);
        for(int i = 0; i < nums.length; i++){
            rSum+= nums[i];

            if(map.containsKey(rSum -k)){
                res += map.get(rSum-k);
            }
            map.put(rSum,map.getOrDefault(rSum,0)+1);
        }
        return res;
    }
}