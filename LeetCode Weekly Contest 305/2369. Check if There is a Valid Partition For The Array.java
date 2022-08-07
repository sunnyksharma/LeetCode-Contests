class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
      // Create a boolean array of length n+1 where n is the length of nums
      // validity[i] will be true if nums array of length i from starting (i.e. from index 0 to index (i-1) ) is valid else false;
        boolean[] validity = new boolean[n+1];
        validity[0] = true; // it means that the array of 0 length will always be valid; base condition.
      
      // will start traversing the array from index 1 because an array of length 1 will always be false.
        for(int i = 1; i<n; i++){
          int curr = nums[i]; // element at curr index
          int prev = nums[i-1]; // element at previous index
          // check if the current element is equal to prev element and array ending before previous element is valid. if yes then array of length i will also be valid.
            if(validity[i-1] && (curr==prev)){
                validity[i+1] = true;
                continue;
            }
          
            if(i==1) continue; // Other conditions are for length three.
          
          
          int beforePrev = nums[i-2]; // element previous to previous index.
          // check if three consecutive elements have difference of 1 with their adjacent elements (i.e. curr-prev = 1; and prev-beforePrev = 1) and array ending
          // before beforePrev element is valid; if yes then array ending at curr index will also be valid.
            if(validity[i-2] && (curr-prev == 1) && (prev - beforePrev == 1)){
                validity[i+1] = true;
            }
          // check if three consecutive elements are equal (i.e. curr == prev and prev == beforePrev ) and array ending
          // before beforePrev element is valid; if yes then array ending at curr index will also be valid.
            if(validity[i-2] && curr == prev && prev == beforePrev){
                validity[i+1] = true;
            }
           
        }
      // Validity of array till index n-1 will be stored at nth index of validity.
        return validity[n];
    }
}
