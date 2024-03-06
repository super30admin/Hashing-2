import java.util.HashMap;
//tc=o(n)
//sc=o(n)
class Solution {
    public int findMaxLength(int[] nums) {
        int length = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1); //important
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                sum = sum + 1;
            }
            else{
                sum = sum -1;
            }

            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
            length = Math.max(length, i - map.get(sum));
           

        }
        return length;
    }
}