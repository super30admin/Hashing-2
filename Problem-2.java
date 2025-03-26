/* Using HashMap: Time complexity: O(n) & Space complexity: O(n) */

class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int rsum = 0, max = 0;

        //map.put(0, -1); // the array is balanced from 0th index
        int start = 0, end = 0;

        for(int i=0; i<n; i++){
            if(nums[i] == 0) rsum--;
            else rsum++;

            if(rsum == 0){
                max = Math.max(max, i+1);
            }
            else if(map.containsKey(rsum)){
                // if(max < i-map.get(rsum)){
                //     start = map.get(rsum) + 1;
                //     end = i;
                // }
                max = Math.max(max, i - map.get(rsum));
            }
            else map.put(rsum, i);
        }

        //System.out.println(start +" "+ end);
        return max;
    }
}