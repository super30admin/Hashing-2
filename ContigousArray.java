//Time Complexity is O(n) and space Complexity is O(n)
public class ContigousArray {
    public int findMaxLength(int[] nums) {
        if(nums.length ==0 || nums == null){
            return -1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int rsum = 0;
        int max = 0;

        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 0){
                rsum = rsum - 1;

            }else{
                rsum = rsum + 1;
            }
            if(!map.containsKey(rsum)){
                map.put(rsum, i);
            }else{
                max = Math.max(max, i - map.get(rsum));
            }

        }
        return max;
    }
}
