import java.util.HashMap;
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

public class subarraySum {
    public int subarraySum(int [] nums,int k){
        if(nums == null || nums.length==0) return 0;
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0, 1);
        int rSum=0;
        for(int i=0;i<nums.length;i++){
            rSum +=nums[i];
            if(map.containsKey(rSum - k)){
                count +=map.get(rSum-k);
            }
            if(map.containsKey(rSum)){
                map.put(rSum,map.get(rSum)+1);
            }
            else{
                map.put(rSum,1);
            }
        }
        return count;
    }
}
