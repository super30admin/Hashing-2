// Time Complexity : O(n)
// Space Complexity : O(n), due to the HashMap storing prefix sums and their counts
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in 3 sentences:
// I used a running prefix sum to keep track of the cumulative sum of elements as I iterate through the array.
// For each prefix sum, I checked if (currentSum - k) has appeared before using a HashMap, indicating a subarray summing to k exists ending at current index.
// I kept track of the frequency of each prefix sum in the HashMap to count all valid subarrays efficiently.



import java.util.HashMap;

public class subArraySum {
    public int solve(int[] nums, int k){
        if(nums==null || nums.length==0){
            return 0;
        }
        int rSum=0, count=0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0,1);
        for(int i=0;i<nums.length;i++){
            rSum = rSum + nums[i];
            if(hmap.containsKey(rSum-k)){
                count = count + hmap.get(rSum-k);
            }
            hmap.put(rSum, hmap.getOrDefault(rSum, 0)+1);
        }

        return count;
    }

    public static void main(String[]args){
        subArraySum ob = new subArraySum();
        int[] nums1 = new int[] {1,1,1};
        int k1 = 2;
        System.out.println(ob.solve(nums1, k1));
        int[] nums2 = new int[] {1,2,3};
        int k2 = 3;
        System.out.println(ob.solve(nums2, k2));



    }
    
}
