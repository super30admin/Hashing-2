import java.util.HashMap;

public class SubArraySum {
   //https://leetcode.com/problems/subarray-sum-equals-k
/*Find the subarrays whose sum account to k
* Maintain a running sum
* Create a hashmap with rSum as key and no. of times  below Process P has occurred as value
* Maintain a count value to give the number of subarrays
* Process
* (rSum-k) = 14-7(for eg rSum =14 and k=7)
* check the difference in hashmap if it is present check how many times it has occurred for eg 2 then add 2 to the count
* Now add the entry to the hashmap, if 14 was already present in hashmap then increment the value in hashmap.
* TC - O(n)
* SC - O(n) - for maintaining a hashmap
*
*
* */
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums,k));
    }

    public  static int subarraySum(int[] nums, int k) {
        if(nums==null || nums.length==0) return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int rSum = 0;
        int count=0;
        map.put(0,1);// dummy value to handle a corner case where only 2 elements are present
        for (int i = 0; i < nums.length; i++) {
            rSum = rSum+nums[i];
            if(map.containsKey(rSum-k)){
                count = count+map.get(rSum-k);

            }
            map.put(rSum,map.getOrDefault(rSum,0)+1);

        }
        return count;
    }



   //Brute Force Approach
    //Time COmplexity - O(n^2)
    //Space Complexity - O(1)
/*
    public  static int subarraySum(int[] nums, int k) {
    if(nums==null || nums.length==0) return 0;
        int count =0;
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = i; j < nums.length ; j++) {
                max +=nums[j];
                if(max==k) count++;
            }
        }
        return count;
    }


 */
}
