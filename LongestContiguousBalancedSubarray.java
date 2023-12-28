
class LongestContiguousBalancedSubarray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int rsum = 0;
        int max = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                rsum++;
            } else {
                rsum--;
            }
            if(map.containsKey(rsum)) {
                max = Math.max(i - map.get(rsum), max);
            } else {
                map.put(rsum, i);
            }
        }

        return max;
    }
}