class Solution {
    public int longestCycle(int[] edges) {
        
        
        int n= edges.length; // number of nodes
        
        int ans = -1; //initially assuming there's no cycle present in graph
        
        // array to keep track of visited nodes
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i<n; i++){
            
            
            if(visited[i] == true) continue;
            
            
            int curr = i;
            int count = 0;
            
            // creat a map to store all the visited node in current cycle and to store its position
            HashMap<Integer,Integer> map = new HashMap<>();
            
            // start a loop to ensure if there's a cycle
            while(curr!=-1 && !visited[curr]){
                map.put(curr,count); // store position of current node
                
                count++; // increase the position
                
                visited[curr] = true; // mark the current node to true so that it does not get repeated again
                curr = edges[curr]; // go for next node
                
            }
            
            // if curr node is already visited it means that it is forming a loop starting from curr node
            // Thus, substracting the current position of the curr node by the prev position of the same node will give the cycle length
            if(curr!=-1 && map.containsKey(curr)) ans = Math.max(count-map.get(curr),ans);
        }
        
        
        return ans;
    }
}
