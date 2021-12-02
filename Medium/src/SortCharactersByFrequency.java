public class SortCharactersByFrequency {
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
