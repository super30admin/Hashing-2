import java.util.HashMap;

public class ContiguousArray {
    //TC is O(N), as we are just going over the complete array
    //SC is O(N), as in the worst where there are no repeating value and we need to store all the values in HashMap.
    public int findMaxLength(int[] nums){
        if(nums == null || nums.length == 0){    //Base case to check if array is empty
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int rsum=0;
        int max=0;
        map.put(0,-1); //First element of Hash Map
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){   //If value is 0 then subtract from running sum
                rsum=rsum-1;
            }
            else{
                rsum=rsum+1;   //As it is binary array so the other element would be 1 and will add 1 to the running sum
            }

            if(map.containsKey(rsum)){      //If running sum is already in the HashMap
                max = Math.max(max, i - map.get(rsum));
            }
            else{                   //If it is not there then add it to HashMap
                map.put(rsum,i);
            }
        }
        return max;
    }



    public static void main(String[] main){
        int[] nums = {0,1,0};
        ContiguousArray obj=new ContiguousArray();
        System.out.println(obj.findMaxLength(nums));
    }
}
