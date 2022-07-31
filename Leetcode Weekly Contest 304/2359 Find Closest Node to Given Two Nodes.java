class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        if(node1==node2) return node1;
        
        
        boolean[] visited = new boolean[n]; // to keep track of visited nodes by node 1
        boolean[] sv = new boolean[n];// to keep track of visited nodes by node 2
        
        // create a loop to traverse all connected elements starting from distance 0 then 1 ,2 and so on...
        // First Element visited by both the nodes will be the answer
        while(node1!=-1 && node2!=-1 && sv[node2] == false && visited[node1]==false){
            
            // mark the current nodes visited in the corresponding boolean arrays
            visited[node1] = true;
            sv[node2]=true;
            
            // check if node1 or node2 is already visited by the second and first node respectively
            
            // both the current nodes are visited by the other nodes then the minimum of the current nodes will be our answer
            if(sv[node1] && visited[node2]) return Math.min(node1, node2);
            if(visited[node2]) return node2;
            if(sv[node1]) return node1;
            
            
            // go to next nodes 
            node1=edges[node1];
            node2=edges[node2];
            
        }
        
        // traverse through the remaining nodes which has still connected nodes left
        
        while(node1!=-1 &&visited[node1]==false ){
            
            if(sv[node1]) return node1;
            visited[node1]=true;
            node1=edges[node1];
        }
        
        while(node2!=-1 &&sv[node2]==false ){
            if(visited[node2]) return node2;
            sv[node2]=true;
            node2 = edges[node2];
        }
        
        // if no node were matched by both the sets return -1;
        return -1;
    }
}
