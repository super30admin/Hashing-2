class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count =0 ;
        int rsum =0;
        map.put(0, 1);
        for(int num: nums) {
            rsum += num;
            int x = rsum - k;
            if(map.containsKey(x)){
                count += map.get(x);
            } 
                map.put(rsum, map.getOrDefault(rsum, 0) + 1);

        }
    return count;
    }

}