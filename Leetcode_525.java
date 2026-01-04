//Rule: Contiguous array-->Number of 1's is equals to number of 0's. 
//Let's consider 1's as increments and 0 as decrements. As number of 1's = number of 0's, number of increments is equals to number of decrements.
//The indexes at which prefix sum is equals will have equal number of 0's and 1's between them.
//prefix sum is calculated using sum variable. And traking the indexes with similar sum using hashmap
//TC: O(n); SC: O(n)
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum=0;
        int ans=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                sum=sum-1;
            }else{
                sum=sum+1;
            }

            if(map.containsKey(sum)){
                ans=Math.max(ans,(i-map.get(sum)));
            }else{
                map.put(sum,i);
            }
        }

        return ans;
        
    }
}
