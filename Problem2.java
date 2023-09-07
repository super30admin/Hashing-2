

// Time complexity : O(n)
//space complexity :O(n)
// Did the code pass all test cases in the leetcode : Yes
//Any problem you faced while coding this : No
import java.util.HashMap;

class Problem2 {
    public int findMaxLength(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int rSum =0;
        int max=0;
        map.put(0,-1);
        for(int i=0;i< nums.length;i++){
            if(nums[i] == 0){
                rSum -=1;
            }else{
                rSum +=1;
            }
            if(map.containsKey(rSum)){
                max = Math.max(max,i- map.get(rSum));
            }else{
                map.put(rSum,i);
            }
        }
        return max;
    }
}