class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int rsum =0;
        int count =0;
        for(int i=0;i<nums.length;i++){
            rsum+=nums[i];
            int cmp = rsum - k;
            if(map.containsKey(cmp)){
                count+=map.get(cmp);
            }
            map.put(rsum,map.getOrDefault(rsum,0)+1);

        }
        return count;
    }
}