class Solution {
    int max;
    public int maximumRows(int[][] mat, int cols) {
        max = 0;
        maxRow(mat,cols,new HashSet<>(), 0);
        return max;
    }
    
    public void maxRow(int[][] arr, int k, HashSet<Integer> set, int i){
        int[][] mat = arr;
        if(i==mat[0].length){
            max = Math.max(max,mat.length - set.size()) ;
            return;
        }
        
        HashSet<Integer> temp = new HashSet<>(set);
        if(k>0){
            maxRow(arr,k-1,set,i+1);
        }
        
        
        for(int j=0; j<mat.length; j++){
            if(arr[j][i] == 1){
                temp.add(j);
            }
        }
        maxRow(arr,k,temp,i+1);
    }
}
