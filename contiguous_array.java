// We check if contigous array exists by calculating running sum
// Time complexity - O(1) <-- as we visit each element only once, linearly
// Space Complexity - O(n) <-- we store sum each time in worse case it is n
class Solution {
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1){
            return 0;
        }

        int max = 0;
        int rSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int i=0;i<nums.length;i++){
            // If n is 0, we subtract from sum
            if(nums[i] == 0){
                rSum = rSum - 1;
            }
            // If n is 1, we add to sum
            else {
                rSum = rSum + 1;
            }
            // If map contains the current sum, that means we have arrived at contigous array
            // We update max value with the total number of elements in the array if it greater than current max
            if(map.containsKey(rSum)){
                max = Math.max(max, i - map.get(rSum));
            }
            // Otherwise we add the running sum to the map
            else{
                map.put(rSum, i);
            }
        }
        return max;
    }
}
