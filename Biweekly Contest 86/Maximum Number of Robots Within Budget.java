class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        int[] nextGreaterElement = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for(int i= 0; i<n; i++){
            int curr = chargeTimes[i];
            while(st.size()>0 && chargeTimes[st.peek()]<=curr){
                int ind = st.pop();
                nextGreaterElement[ind]= i;
            }
            st.push(i);
        }
        while(st.size()>0){
            nextGreaterElement[st.pop()] = -1;
        }
        
        int start = 0;
        int end = 0;
        long cost = chargeTimes[0] + runningCosts[0];
        int ans = 0;
        int maxi = 0;
        
        long[] sumtilli = new long[n];
        for(int i= 0; i<n; i++){
            if(i==0) sumtilli[i] = runningCosts[i];
            else sumtilli[i] = sumtilli[i-1] + runningCosts[i];
        }
        
        
        while(end < n){
            if(end<start){
                end++;
                
                continue;
            }
            
            while(maxi<start || (nextGreaterElement[maxi]<=end && nextGreaterElement[maxi] != -1)){
                    if(maxi<start && (nextGreaterElement[maxi] == -1 || nextGreaterElement[maxi]>end )){
                        maxi++;
                        continue;
                    }
                    maxi = nextGreaterElement[maxi];
            }
            
            long temp = sumtilli[end] - (start==0?0:sumtilli[start-1]);
            cost = chargeTimes[maxi] + (end-start+1)*temp;
            
            
            if(cost <= budget){
                ans = Math.max(ans, end-start+1);
                end++;
                
                
            } else {
                start++;
                
                
            }
           // System.out.println(cost + " " + start + " "+ end +" " + ans);
            
        }
        if(cost<=budget){
            ans = Math.max(ans, end-start);
        }
        return ans;
    }
}
