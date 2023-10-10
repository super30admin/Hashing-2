// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I didnt face any problem while coding this.
class ContigousArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,-1);
        int start = 0, end = 0;
        int max = 0;
        for(int i=0; i< nums.length; i++){
            if(nums[i] == 0){
                sum = sum - 1;
            }else{
                sum = sum + 1;
            }
            if(map.containsKey(sum)){
                if(max < i-map.get(sum)){
                    //to find the start index of the longest sub array
                    max = Math.max(max, i-map.get(sum));
                    start = map.get(sum) + 1;
                    end = i;
                }

            }else{
                map.put(sum,i);
            }
        }
        return max;
    }
}