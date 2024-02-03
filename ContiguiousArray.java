//The algorithm finds the maximum length of a contiguous subarray with an equal number of 0s and 1s in a binary array nums. 
//It uses a running sum (rsum) to track the cumulative difference between the counts of 0s and 1s. A HashMap (map) is employed to store the first occurrence of each unique rsum. 
//The maximum length is updated by calculating the difference between the current index and the index stored in the map when encountering the same rsum.
// The algorithm iterates through the array once, achieving a time complexity and space complexity of O(n).
class Solution {
    public int findMaxLength(int[] nums) {
        int max =0, rsum =0;
        HashMap<Integer, Integer> map  = new HashMap<>();
        map.put(0,-1); // for intial balanced subarray
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0 ) rsum--;
            else rsum++;
            if(map.containsey(rsum))  max = Math.max(max, i-map.get(rsum));
            else map.put(rsum,i);
        }
        return max;
    }
}