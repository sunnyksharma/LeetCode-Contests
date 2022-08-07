class Solution {
    public int longestIdealString(String s, int k) {
        
        // create a map which will have key as a character and value as the last index of key character in String s
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int ans = 0;
        int[] dp = new int[n]; // at index i it will store the longest Ideal String which will end and contain ith character of String s
        for(int i = 0;i<n; i++){
            dp[i] = 1; 
            
            char curr = s.charAt(i); // character at index i
            
            // traverse from 'a' to 'z';
            for(int j = 0; j<=25; j++){
                char temp = (char) ('a'+j); // character to compare
                
                // if absolute difference between curr and temp is less than or equal to k then the current element can be added to the string ending with temp character.
                if(Math.abs(temp-curr)<=k){
                    
                    // if map contains temp, it means we have a string which is ideal and ending at temp.
                    if(map.containsKey(temp)){
                        
                        dp[i] = Math.max(dp[map.get(temp)]+1,dp[i]); // if the length of the string after connecting the curr to temp is more than current length, update the length;
                    }
                }
            }
            ans = Math.max(dp[i],ans); // update the answer with maximum value possible
            map.put(curr,i); // map the curr element with its latest index
        }
        // Return the answer
        return ans;
    }
}
