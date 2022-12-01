class ContiguousSubArray {
    /*
    Using running sum pattern to reduce the number of comparisons.
    If the rsum at index x and index y are equal then the subarray between x and y is balanced.

    whenever 0 occurs we will decrease the count and for 1 we will increase the count.
    In the end if sum equals to 0 means we have equal number of zeros and one's.

    using hashmap for easy lookup

    Space complexity: o(n)
    Time complexity: o(n )

     */
    public int findMaxLength(int[] nums) {
        int runningSum = 0;
        int maxLength = 0;

        //map of rSum and index
        Map<Integer, Integer> map = new HashMap<>();

        // For handling edge case where nums =[1, 0]
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                runningSum--;

            } else {
                runningSum++;
            }
            if (!map.containsKey(runningSum)) {
                map.put(runningSum, i);

            } else {
                int existingIdxwithRSum = map.get(runningSum);
                maxLength = Math.max(maxLength, i - existingIdxwithRSum);

            }
        }
        return maxLength;

    }
}