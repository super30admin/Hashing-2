import java.util.HashMap;

class SubArraySum {

    //TC will be O(N) as iterated over the whole array and other operations just take constant time
    //SC will be O(N), as in worst case we need to store all th N elements in HashMap
    public int subarraySum(int[] nums, int k) {
        if(nums==null || nums.length==0){ //Base case when array is empty
            return 0;
        }

        HashMap<Integer, Integer> map=new HashMap<>();
        int rSum=0;
        int count=0;

        map.put(0,1);      //put first value in the HashMap

        for(int i=0;i<nums.length;i++) {        //to iterate over the array
            rSum = rSum + nums[i];   //to calculate the running sum
            if(map.containsKey(rSum - k)){          //Cond to check if already the in HashMap
                count= count + map.get(rSum-k);     //Then update count
            }
            map.put(rSum, map.getOrDefault(rSum,0)+1);
        }
        return count;
    }

    public static void main(String[] args){
        int[] nums = {1,1,1};
        int k = 2;
        SubArraySum obj= new SubArraySum();
        System.out.println(obj.subarraySum(nums,k));
    }
}