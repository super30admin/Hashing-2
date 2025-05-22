//time complexity:O(n)
//space:O(n)
// Running sum question: whever we have iterative solutions we can try running sum solution.
// So if we have sum at x and y , we don't have to find the sum at z, becs x=y+z, so z=x-y, so we will maintain a hashset
// where we will store index of the first time a sum has occured as value(y) and if it has occured one more time(x)at ith location
// if we sub both we will get the length of balanced subarray, because z==y then z=0 which means it is balanced.
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int rsum=0;
        int max=0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]==0){
                rsum-=1;
            }else{
                rsum+=1;
            }
            if(map.containsKey(rsum)){
                max= Math.max(max,i-map.get(rsum));
            }
            else{
                map.put(rsum,i);
            }
        }
        return max;
    }
}
