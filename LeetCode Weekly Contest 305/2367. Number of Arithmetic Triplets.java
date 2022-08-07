class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        // Create a Hashset to  store elements
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        
        // Intialise count from 0 in which we will store the count of required triplet
        int count = 0;
        
        for(int i = 0; i<n; i++){
            
            // check if including the current element we can have a triplet or not.
            // how to check : as the array is strictly increasing we need not to worry about order. just need to check
            // if required elements to complete triplet are in the set. if yes increase the count;
            if(set.contains(nums[i]-diff) && set.contains(nums[i]-diff-diff)){
                
                count++;
                
            }
            
            // Store the current element into set
            set.add(nums[i]);
        }
        return count;
    }
}
