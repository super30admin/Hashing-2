// Time complexity O(n)
// Space complexity O(n)
// calculate the running sum. The idea is a subarray is always balanced between same rSum values.
// store the index of first occurence and substract from the index of second occurance to get the length
// of balance array. The max length would be present difference of two farthest indexes.
class Problem2 {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // put a dummy value
        int rSum = 0;
        int maxLength = 0;
        for (int i=0; i<nums.length;i++){
            if(nums[i] == 1){
                rSum += 1;
            } else {
                rSum -= 1;
            }
            if(map.containsKey(rSum)){
                maxLength = Math.max((i-map.get(rSum)), maxLength);
            } else {
                map.put(rSum, i);
            }
        }
        return maxLength;
    }
}