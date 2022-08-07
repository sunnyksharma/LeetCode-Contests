class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        // Make an array (tree) of ArrayList
        // Arraylist at index i of tree will hold all the nodes connected to i node.
        ArrayList<Integer>[] tree = new ArrayList[n];
        
        // Initialize all the indexes of tree
        for(int i = 0; i<n; i++){
            tree[i] = new ArrayList<>();
        }
        int count = 0; //It will store our answer
        
        // traverse through edges to make tree
        for(int i =0;i<edges.length; i++){
            int u = edges[i][0]; 
            int v = edges[i][1];
            // u and v are connected to each other
            tree[u].add(v); // connect u to v in tree
            tree[v].add(u); // conncet v to u in tree
        }
        
        
        boolean[] visited = new boolean[n]; // will store true at index i if node i is already visited
        
        // mark all the restricted nodes as already visited
        for(int i =0; i<restricted.length; i++){
            visited[restricted[i]] = true;
        }
        
        
        // BFS
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        
        while(q.size()>0){
            int rem = q.remove();
            
            
            if(visited[rem]) continue;  // if node val is visited no action will be taken because either its already taken into count before or it is restricted
            
            count++; // increase the count as we can reach node rem from node 0;
            visited[rem] = true; // mark node rem as true 
            for(int val: tree[rem]){
                
                if(visited[val]) continue; // if node val is visited no action will be taken because either its already taken into count before or it is restricted
                
                q.add(val); // if neither visited nor restricted. add it to the queue.
            }
        }
        return count;
    }
}
