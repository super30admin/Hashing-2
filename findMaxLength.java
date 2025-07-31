//You iterate through the binary array while maintaining a running sum where 0 is treated as -1, 1 is treated as +1. This running sum helps track the balance between the number of 1s and 0s. If the sum at a current index has been seen before, it means the subarray between the previous occurrence and the current index is balanced (equal number of 0s and 1s). You use a hash map to store the first occurrence of each sum value, allowing you to compute the maximum length of such balanced subarrays efficiently.

//the time complexity here would be O(n)  since we are iterating through the array.

//the space complexity here would be again O(n) since we are iterating and storing at each point the summit the hash map.

class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int max = 0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int runSum=0;
        map.put(runSum,-1);
        for (int i = 0; i < n; i++) {
            if(nums[i]==1)runSum++;
            else runSum--;
            if(map.containsKey(runSum)){
                max=Math.max(max,i-map.get(runSum));
            }else map.put(runSum,i);
        }
        return max;
    }
}
