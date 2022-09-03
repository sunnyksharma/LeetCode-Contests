class Solution {
    public int shortestSequence(int[] rolls, int k) {
        int n = rolls.length - 1;
        int count = 1;
        HashSet<Integer> set = new HashSet<>();
        for(int i = n; i>=0; i--){
            set.add(rolls[i]);
            if(set.size()==k){
                set.clear();
                count++;
            }
        }
        return count;
    }
}
