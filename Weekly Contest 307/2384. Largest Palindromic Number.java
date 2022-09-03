class Solution {
    public String largestPalindromic(String num) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<num.length(); i++){
            char ch = num.charAt(i);
            int val = ch-'0';
            map.put(val, map.getOrDefault(val,0)+1);
            
        }
        int middle = -1;
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i>=0; i--){
            int freq = map.getOrDefault(i,0);
            if(i==0 && sb.length()==0) freq = Math.min(1,freq);
            for(int j = 0; j<freq/2; j++){
                
                sb.append(i);
            }
            middle = freq%2==1?Math.max(middle,i):middle;
        }
        StringBuilder suffix = new StringBuilder(sb);
        suffix = suffix.reverse();
        if(middle != -1) sb.append(middle);
        sb.append(suffix);
        //if(sb.length())
        return sb.toString();
    }
}
