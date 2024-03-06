import java.util.HashMap;

class Solution {
    /* Time Complexity ;O(n);
       Space Complexity: O(n);
    
       Executed in leetcode;
     */
        public int subarraySum(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int count = 0;
            int rsum = 0;
            for (int i =0; i <nums.length; i++){
                rsum += nums[i];
                int y = rsum - k;
                if (map.containsKey(y)){
                    count+= map.get(y);
                }
                if(!map.containsKey(rsum)){
                    map.put(rsum, 1);
                }else{
                    map.put(rsum, map.get(rsum) + 1);
                }
            }
            return count;
        }
    }