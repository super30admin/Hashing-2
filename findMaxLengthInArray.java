// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class findMaxLengthInArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int count=0;
        int sum=0;
        if(nums.length<=1)return 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
              sum+=1;
            }else{
                sum-=1;
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
            else{
                int tempCount=i-map.get(sum);
                count=Math.max(count,tempCount);
            }
        }
        return count;
    }
}
