public class SortCharactersByFrequency {
//     Runtime: 12 ms, faster than 75.21% of Java online submissions for Sort Characters By Frequency.
// Memory Usage: 39.8 MB, less than 86.85% of Java online submissions for Sort Characters By Frequency.

    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        
        char[] chars = s.toCharArray();
        for (char c: chars){
            freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
        }
        
        // sort
        List<Character> characters = new ArrayList<>(freqMap.keySet());
        Collections.sort(characters, (a, b) -> freqMap.get(b) - freqMap.get(a));
        
        StringBuilder res = new StringBuilder();
        
        for (char c: characters){
            for (int i = 0; i < freqMap.get(c); i++){
                res.append(c);
            }
        }
        
        return res.toString();
    }
}
