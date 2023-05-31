
import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {

        // Brute force method: generate all possible subarrays and check if they are balance

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1); // offset current rsum=0 for -1
        int max = 0; // 
        int rsum = 0; // 
        for (int i=0; i<nums.length; i++) {
            if (nums[i]==1) rsum++;
            else rsum--;

            if (map.containsKey(rsum)){
                if (max < (i-map.get(rsum))) max = i-map.get(rsum);
            } else map.put(rsum,i);


        }

        return max;
    }
}





/* 

// time Complexity = O(n^2)
// space : O(1)

class Solution {
    public int findMaxLength(int[] nums) {

        // Brute force method: generate all possible subarrays and check if they are balance

        int max = 0;

        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (isBalanced(nums, i, j) && (j-i)>max) max = j-i+1;
            }
        }
    }

    public boolean isBalanced(int[] nums, int l, int h) {
        int sum = 0;
        for (int i=l; i<=h; i++){
            if (nums[i] == 1) sum++;
            else sum--;
        }

        return sum==0;
    }
}


        // Using runnignSum property to remove extra iterations
        // sum of subarry[i,j] = rumSum[j] - runSum[j]
        // if balanced means sum of Subarray = 0 -> runsum[i] = runsum[j];
        // so we use hashmap if runsum appeared already
*/
