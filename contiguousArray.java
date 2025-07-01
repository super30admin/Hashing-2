// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in 3 sentences:
// I converted all 0s in the array to -1 so that the problem of finding equal numbers of 0s and 1s becomes a problem of finding a subarray with sum = 0.
// I used a HashMap to store the first occurrence index of each running sum (rSum).
// If the same rSum appears again, it means the subarray between the previous index and the current one has equal number of 0s and 1s, so I update the max length.



import java.util.HashMap;

public class contiguousArray {
    public int solve(int[] nums){
        if(nums==null || nums.length==0 || nums.length == 1){
            return 0;
        }
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int max=0;
        int rSum = 0;
        hmap.put(0, -1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                rSum-=1;
            }
            else{
                rSum+=1;
            }
            if(hmap.containsKey(rSum)){
                max = Math.max(max, i - hmap.get(rSum));

            }
            else{
                hmap.put(rSum, i);
            }

        }
        return max;


    }
    public static void main(String[]args){
        contiguousArray ob = new contiguousArray();
        int [] nums1 = new int[] {0,1};
        int [] nums2 = new int[] {0,1,0};
        int [] nums3 = new int[] {0,1,1,1,1,1,0,0,0};
        System.out.println("Length of longest continuous subarray is with equal no of 0's and 1's is:  "+ob.solve(nums1));
        System.out.println("Length of longest continuous subarray is with equal no of 0's and 1's is:  "+ob.solve(nums2));
        System.out.println("Length of longest continuous subarray is with equal no of 0's and 1's is:  "+ob.solve(nums3));

    }
}
