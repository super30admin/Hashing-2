class BruteForce{
    public int subarraySum(int[] nums, int k) {
        int [] nums2 = new int[nums.length];
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            nums2[i] = sum;
        }

        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == k) {
                ans ++;
            }
            for (int j = i + 1; j < nums2.length; j ++) {
                if ( nums2[j] - nums2[i] == k ) {
                    ans ++;
                }
            }
        }
        return ans;
    }

}