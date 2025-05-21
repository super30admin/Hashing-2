//Time Complexity = O(n)
//Space Complexity = O(n)


class Solution {
    public int findMaxLength(int[] nums) {
        int count = 0;
        int rSum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
       map.put(0,-1);

       for(int i=0; i<nums.length; i++){
        if(nums[i]==0){
            rSum--;
        }
        else{
            rSum++;
        }
        if(map.containsKey(rSum)){
            count = Math.max(count,i - map.get(rSum));
        }
        else{
            map.put(rSum,i);
        }
       }
       return count;

    }
}