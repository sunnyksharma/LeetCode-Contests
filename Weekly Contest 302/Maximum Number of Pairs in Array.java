class Solution {
    public int[] numberOfPairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length; i++){
            int val = nums[i];
            map.put(val,map.getOrDefault(val,0)+1);
        }
        int pair = 0;
        int alone = 0;
        for(int key: map.keySet()){
            int val = map.get(key);
            pair += (val/2);
            alone += (val%2);
        }
        return new int[]{pair,alone};
    }
}
