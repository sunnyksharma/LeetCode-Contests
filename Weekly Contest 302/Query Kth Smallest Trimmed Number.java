class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        HashMap<Integer,int[]> map = new HashMap<>();
        int[] ans = new int[queries.length];
        for(int i = 0; i<queries.length; i++){
            int[] query = queries[i];
            int idx = query[0];
            int k = query[1];
            if(map.containsKey(k)){
                int[] temp = map.get(k);
                ans[i] = temp[idx-1];
            } else{
                int[] temp = make(nums,nums[0].length()-k);
                map.put(k,temp);
                ans[i] = temp[idx-1];
            }
        }
        return ans;
    }
    
    public int[] make(String[] nums, int k){
        Pair[] temp = new Pair[nums.length];
        for(int i = 0; i<nums.length; i++){
            String val = nums[i].substring(k);
            
            temp[i] = new Pair(val,i);
        }
        Arrays.sort(temp);
        int[] arr = new int[temp.length];
        for(int i = 0; i<temp.length; i++){
            arr[i] = temp[i].idx;
        }
        return arr;
    }
    public class Pair implements Comparable<Pair>{
        String val;
        int idx;
        public Pair(String v, int i){
            this.val = v;
            this.idx = i;
        }
        
        public int compareTo(Pair op){
            int i = 0;
            while(i<op.val.length()){
                int d = this.val.charAt(i) - op.val.charAt(i);
                if(d!=0){
                    return d;
                }
                i++;
            }
            return this.idx-op.idx;
        }
    }
}
