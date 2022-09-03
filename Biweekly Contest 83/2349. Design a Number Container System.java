class NumberContainers {
    HashMap<Integer,PriorityQueue<Integer>> map;
    HashMap<Integer,Integer> con;

    public NumberContainers() {
        map = new HashMap<>();
        con = new HashMap<>();
    }
    
    public void change(int index, int number) {
        

        PriorityQueue<Integer> q = map.getOrDefault(number,new PriorityQueue<>());
        q.add(index);
        map.put(number,q);
        con.put(index,number);


    }
    
    public int find(int number) {
        PriorityQueue<Integer> q = map.getOrDefault(number, new PriorityQueue<>());
        while(q.size()>0 && con.get(q.peek())!=number){
            q.remove();
        }
        return q.size()>0?q.peek():-1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
