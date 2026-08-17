class Solution {
    public int findMaxLength(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int rsum =0;
        map.put(0, -1);
        for(int i =0; i< nums.length; i++) {
            if(nums[i] == 0) {
                rsum = rsum -1;
            } else {
                rsum = rsum +1;
            }
            if(map.keySet().contains(rsum)) {
                int m = i - map.get(rsum);
                if(m > max) {
                    max = m;
                }
            } else {
                map.put(rsum, i);
            }
        }
        return max;
     }
}