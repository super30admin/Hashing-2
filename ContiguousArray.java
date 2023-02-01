/**
 * Author: Shubhangi
 * TC: O(n)
 * SC: O(n)
 * Leetcode done: YEs
 * Problem Faced: Had difficulty understanding the approach and map initial assignment to 0,-1
 */
import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
        public static void main(String args[]){
            int arr[] = {0,1,0};
            ContiguousArray obj = new ContiguousArray();
            int maxLength = obj.findMaxLength(arr);
            System.out.println(maxLength);
        }
        public int findMaxLength(int[] nums) {
           int maxLength=0, rsum = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            for(int i = 0; i < nums.length; i++){
            	if(nums[i] == 0){
                    rsum --;
                } else if(nums[i] == 1){
                    rsum ++;
                }
                if(!map.containsKey(rsum)){
                    map.put(rsum, i);
                }else if(map.containsKey(rsum)){
                    maxLength = Math.max(maxLength, i - map.get(rsum));
                }
            }
            return maxLength;
        }
}
