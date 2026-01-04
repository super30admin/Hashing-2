//As they are asking subarray sum, have a variable and maintain sum in it at every index. At every index, we need some amount to match with target. That amount can be calculated as sum-target. 
//To check whether we have any sum-target in the array, we will maintain a map and count number of occurances of quantity(sum) at every index. If it's present, that many times we have the possibility to reach target.
//Tc: O(n)
//Sc: O(n)

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0;
        int sum=0;

        for(int i:nums){
            sum+=i;
            int target=sum-k;
            if(map.containsKey(target)){
                count+=map.get(target);
            }

            map.put(sum,map.getOrDefault(sum,0)+1);
        }

        return count;
        
    }
}
