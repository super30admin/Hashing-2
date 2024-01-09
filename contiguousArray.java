import java.util.*;
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, -1);

        int maxLength = 0;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currentSum++;
            } else {
                currentSum--;
            }
            if (sumMap.containsKey(currentSum)) {
                maxLength = Math.max(maxLength, i - sumMap.get(currentSum));
            } else {
                sumMap.put(currentSum, i);
            }
        }

        return maxLength;
        /*
        //Tc: O(n^2) Sc: O(1)
        int maxim = 0;
        for(int i = 0 ; i < nums.length; i++){
            int zeros = 0;
            int ones = 0;
            for(int j = i ; j < nums.length; j++)
            {
                if(nums[j] == 0) zeros += 1;
                else ones += 1;
                if(zeros == ones)
                {
                    maxim = Math.max(maxim, j-i+1);
                }   
            }
        }
        return maxim;
        */
    }
}
