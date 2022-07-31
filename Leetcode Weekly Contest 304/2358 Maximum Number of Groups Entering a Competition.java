class Solution {
    public int maximumGroups(int[] grades) {
        int len = grades.length;
        int ans = 0;
      // Using first N number sum
        for(int i = 1; i*i<=2*len-i;i++) {
            ans = i;
        }
        return ans;
    }
}
