class Solution {
    public int minNumberOfHours(int enrg, int exp, int[] energy, int[] experience) {
        long ans = 0;
        int n = energy.length;
        for(int i = 0; i<n; i++){
            int enrg_req = energy[i];
            int exp_req = experience[i];
            if(exp>exp_req){
                exp += exp_req;
            } else{
                ans += (exp_req - exp +1);
                exp = 2*exp_req + 1;
            }
            if(enrg>enrg_req){
                enrg -= enrg_req;
            } else{
                ans += (enrg_req - enrg + 1);
                enrg = 1;
            }
        }
        return (int) ans;
    }
}
