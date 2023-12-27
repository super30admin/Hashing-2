//Accepted on leetcode
//Same approach as P1 used running sum and Hashmap
//Time,space O(n) 
class Solution {
    public int findMaxLength(int[] nums) {
        int sum = 0;
        int max = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                sum = sum - 1;
            }
            else{
                sum = sum + 1;
            }
            if(hm.containsKey(sum)){
                int diff = i - hm.get(sum);
                if(diff>max){
                    max = diff;
                }
            }
            else{
                hm.put(sum,i);
            }

            




        }
        return max;


        
    }
}