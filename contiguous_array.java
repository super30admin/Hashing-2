//Space complexity O(n)
//Time complexity O(n)
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int result=Integer.MIN_VALUE;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                sum--;
                nums[i]=sum;
            }
            else
            {
                sum++;
                nums[i]=sum;
            }
            if(map.containsKey(sum))
            {
if(i-map.get(sum)>result)
result=i-map.get(sum);
            }
            else
            {
                map.put(sum,i);
            }
        }
        if(result==Integer.MIN_VALUE)
        result=0;
        return result;

        
    }
}