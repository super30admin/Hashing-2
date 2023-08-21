// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
import java.util.HashMap;

class subarraySumK {
        public int subarraySum(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return 0;
        }
        
        int total=0;
        int rSum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);

        for(int i=0;i<nums.length;i++){
            rSum=rSum+nums[i];
            if(map.containsKey(rSum - k)){
               total = total + map.get(rSum-k);
            }
            map.put(rSum,map.getOrDefault(rSum,0)+1);
        }
        return total;
        
    }

    public static void main(String[] args) {
    subarraySumK rs = new subarraySumK();
    int[] m1 = {1,1,1};
    int[] m2 = {1,2,3};
    System.out.println(rs.subarraySum(m1,2));  // ans = 2
    System.out.println(rs.subarraySum(m2,3));  // ans = 2
}

}