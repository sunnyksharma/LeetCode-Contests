class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int res = resHCF(numsDivide,0,numsDivide.length-1);
        boolean flag = false;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length; i++){
            int div = nums[i];
            if(res%div == 0){
                flag = true;
                ans = Math.min(ans,div);
            }
        }
        if(!flag) return -1;
        int count = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]<ans){
                count++;
            }
        }
        return count;
    }
    
    public int getHCF(int i, int j){
        if(i==0) return j;
        return getHCF(j%i,i);
    }
    
    public int resHCF(int[] nums, int s, int e){
        if(s==e) return nums[s];
        int mid = s+(e-s)/2;
        int left = resHCF(nums, s,mid);
        int right = resHCF(nums,mid+1,e);
        int ans = getHCF(left,right);
        return ans;
    }
}
