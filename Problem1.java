class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int sum = 0;
        int result = 0;
        if(nums==null || nums.length==0)
        {
            return 0;
        }
        map.put(0,1);
        for(int i = 0;i<nums.length;i++)
        {
            sum += nums[i];
            if(map.containsKey(sum-k)){
            result += map.get(sum-k);
            }
            if(map.containsKey(sum)){
                int n = map.get(sum);
                n++;
                map.put(sum,n);
            }
            else{
                map.put(sum,1);
            }
            
        }return result;
    }
}
