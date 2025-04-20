// Time Complexity :o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int j=0;j<nums.length;j++){
            sum += nums[j];
            if(map.containsKey(sum -k)){
                ans += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}


// Time Complexity :o(n)
// Space Complexity :o(n)

// Your code here along with comments explaining your approach
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int zero=0,one=0, maxlen=0;
        map.put(0,-1);

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
            zero++;
            }else{
                one++;
            }
            int diff=zero-one;

            if(map.containsKey(diff)){
                maxlen=Math.max(maxlen,i-map.get(diff));
            }else{
                map.put(diff,i);
            }
        }
        return maxlen;
    }
}