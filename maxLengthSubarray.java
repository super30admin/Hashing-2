//Time Complexity: O(n)
//Space Complexity: O(n)
//where n is length of the array
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1); //create a dummy entry
        int max = 0; int rSum = 0;
        //iterate thru the array
        for(int i = 0; i< nums.length; i++){
            if(nums[i] == 0){
                rSum--;
            }else{
                rSum++;
            }
            if(map.containsKey(rSum)){
                max = Math.max(max, i - map.get(rSum));
            }else{
                map.put(rSum,i);
            }
        }
        return max;
    }
}