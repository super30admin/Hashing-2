// TC - O(n)
// SC - O(n)
class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int rSum = 0;
        map.put(0, -1);

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                rSum--;
            } else {
                rSum++;
            }
            if(map.containsKey(rSum)) {
                max = Math.max(max, i - map.get(rSum));
            } else {
                map.put(rSum, i);
            }
        }
        return max;
    }
}