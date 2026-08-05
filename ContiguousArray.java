// Approach: While traversing the array, Keep a running Sum that decrements when the element in array is 0 and increments when the element is 1
// and check if the running Sum is already present in the hashMap, if so, get the different between current index and index the runningSum occured before
// and check for the maximum

// Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {
    public int findMaxLength(int[] nums) {

        if (nums == null || nums.length == 0){
            return 0;
        }

        int rSum = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        // To handle edge case related to identifying the balanced contigous array happening in the beginning
        map.put(0, -1);

        for(int i = 0; i < nums.length; i++)
        {
            int num = nums[i];
            if (num == 0){
                rSum--;
            }
            else{
                rSum++;
            }

            if (rSum == 0){
                max = Math.max(max, i+1);
            }

            if (map.containsKey(rSum))
            {
                // we get the difference of current index and the index where the running Sum happened earlier and finding the maximum length.
                max = Math.max(max, i-map.get(rSum));
            }
            else
            {
                map.put(rSum, i);
            }
        }
        return max;
    }
}