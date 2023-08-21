// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
import java.util.HashMap;

class contiguousArray {
         public int findMaxLength(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int max=0;
        int rSum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                rSum=rSum-1;
            }
            else{
                rSum=rSum+1;
            }
            if(map.containsKey(rSum)){
                max=Math.max(max,i-map.get(rSum));
            }
            else{
                map.put(rSum,i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
    contiguousArray rs = new contiguousArray();
    int[] m1 = {0,1};
    int[] m2 = {0,1,0};
    System.out.println(rs.findMaxLength(m1));  // ans = 2
    System.out.println(rs.findMaxLength(m2));  // ans = 2
}

}