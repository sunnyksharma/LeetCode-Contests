class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        HashMap<Integer,Integer> rank = new HashMap<>();
        HashSet<Character> suit = new HashSet<>();
        //Hash
        int max = 0;
        for(int i = 0; i<5; i++){
            rank.put(ranks[i],rank.getOrDefault(ranks[i],0)+1);
            suit.add(suits[i]);
            max = Math.max(rank.get(ranks[i]),max);
        }
        if(suit.size()==1){
            return "Flush";
        }
        if(max>=3){
            return "Three of a Kind";
        }
        if(max == 2){
            return "Pair";
        }
        return "High Card";
    }
}
