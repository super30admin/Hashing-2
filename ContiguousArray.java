class ContiguousArray {
    public int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> rSum = new HashMap<>();
        rSum.put(0, -1);
        int sum = 0, max = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;

            if(rSum.containsKey(sum)) {
                max = Math.max(max, i - rSum.get(sum));
            } else {
                rSum.put(sum, i);
            }
        }

        return max;

    }
}