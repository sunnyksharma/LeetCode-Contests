class Solution {
    public boolean findSubarrays(int[] nums) {
        HashMap<Integer,Integer> set = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i<n-1; i++){
            int curr = nums[i] + nums[i+1];
            if(set.containsKey(curr)){
                return true;
            } else{
                set.put(curr,i);
            }
        }
        return false;
    }
}
