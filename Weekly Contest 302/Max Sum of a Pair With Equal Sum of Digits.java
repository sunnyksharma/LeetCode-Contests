class Solution {
    public int sumOfDigits(int num){
        int s = 0;
        while(num>0){
            s += (num%10);
            num/=10;
        }
        return s;
    }
    public int maximumSum(int[] nums) {
        HashMap<Integer,Pair> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int val = nums[i];
            int sum = sumOfDigits(val);
            Pair pair = map.getOrDefault(sum,new Pair());
            if(val>=pair.max){
                pair.smax = pair.max;
                pair.max = val;
            } else if(val>pair.smax){
                pair.smax = val;
            }
            map.put(sum,pair);
        }
        int ans = -1;
        for(int key : map.keySet()){
            Pair pair = map.get(key);
            if(pair.smax>=0){
                ans = Math.max(pair.smax+pair.max,ans);
            }
        }
        return ans;
        
        
    }
    
    public class Pair{
        int max=-1;
        int smax = -1;
        
    }
}
