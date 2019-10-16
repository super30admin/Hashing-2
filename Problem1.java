import java.util.HashMap;

//Time Complexity :  O(n3) for the Brute Force. method subarraySum.  O(n) for the Hashmap Methodm
//Space Complexity : O(1) for the Brute Force. method subarraySum.   O(n) for the Hashmap Methodm
//Did this code successfully run on Leetcode : Yes 
//Any problem you faced while coding this : Hashmap is not clear for me.


//Your code here along with comments explaining your approach 
//Brute force is the way traverse through whole array from 0 to n and find the sub array sum with using the another for loop from 1 to n, 
// here we get sub array 0 to 1 , in the third loop. calculate the sum and if it is equal increase the counter .

 class Solution {
    public int subarraySum(int[] nums, int sumwanted) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {       
            for (int j = i + 1; j <= nums.length; j++) {
                int sum = 0;
                for (int k = i; k < j; k++)
                    sum += nums[i];
                if (sum == sumwanted)
                    count++;
            }
        }
        return count;
    }
    
    //
    
    
    public int subarraySumwithHashMap(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        
        map.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}

public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nums[] = {1,1,1,2,9,3,4,5,6,7,3,2,-4,-2,3,1};

		Solution s = new Solution();
		System.out.println(s.subarraySum(nums, 2));
		System.out.println(s.subarraySumwithHashMap(nums, 2));
		
	}

}
