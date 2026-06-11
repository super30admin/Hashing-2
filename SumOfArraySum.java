import java.util.HashMap;

public class SumOfArraySum {
    
public static int sumOfArray(int[] arr,int k) {
    HashMap<Integer,Integer> map = new HashMap<>();
    map.put(0,1);
    int rsum = 0;
    int count = 0;
    for(int i = 0;i<arr.length;i++){
        rsum += arr[i];
        if(map.containsKey(rsum-k)){
            count+=map.get(rsum-k);
        }
        if(map.containsKey(rsum)){
            map.put(rsum,map.get(rsum)+1);
        }
        else{
            map.put(rsum,1);
        }
    }

    return count;

}
    public static void main(String[] args) {
        int[] arr = {3,4,7,2,-3,1,4,2,0,1};
        int sum = sumOfArray(arr,7);
        System.out.println("The sum of the array is: " + sum);
    }
}
