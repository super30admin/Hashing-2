//o(n) - time complexity.
//o(n) - space complexity.
class Subarray {
    public int subarraySum(int[] nums, int k) {
        int sum=0;
        int count=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            if(map.containsKey(sum-k)){
                count = count + map.get(sum-k);
            }
            if(map.containsKey(sum)){
                int temp = map.get(sum);
                map.put(sum,temp+1);
            }
            else{
                map.put(sum,1);
            }
        }
        return count;
    }
}