class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        // for each pair
        //  for each person in the pair
        //      check if its partner is on the first of its pref list
        //          and if there is another person that it prefers more from another pair that also prefers this person over its current partner
        
        // construct ranking list
        // for each person, store the value of the index of ppl in its pref list as priority score
        int[][] ranking = new int[n][n];
        for (int person = 0; person < n; person++){
            int[] prefList = preferences[person];
            for (int priority = 0; priority < preferences[person].length; priority++){
                ranking[person][prefList[priority]] = priority;
            }
        }
        
        // construct the pair list
        int[] partner = new int[n]; // value is the corresponding partner of each person
        for (int[] pair: pairs){
            partner[pair[0]] = pair[1];
            partner[pair[1]] = pair[0];
        }
        
        int count = 0;
        for (int[] pair: pairs){
            // if pair[0] does not prefer pair[1] the most
            if (ranking[pair[0]][pair[1]] != 0 && isUnhappy(pair[0], pair[1], ranking, partner, preferences)){
                count++;
            }
            
            if (ranking[pair[1]][pair[0]] != 0 && isUnhappy(pair[1], pair[0], ranking, partner, preferences)){
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isUnhappy(int person1, int person2, int[][] ranking, int[] partner, int[][] preferences){
        int currentPartnerRanking = ranking[person1][person2];
        
        // any friend has lower index than current partner ranking is more prefered by person1
        for (int i = 0; i < currentPartnerRanking; i++){
            int friendId = preferences[person1][i];
            // check if that friend also prefers person1 more than its current partner
            int currentFriendPartnerRanking = ranking[friendId][partner[friendId]];
            int friendPriorityForPerson1 = ranking[friendId][person1];
            // larger ranking means less preferred
            if (currentFriendPartnerRanking > friendPriorityForPerson1){
                return true;
            }
        }
        
        return false;
    }
}