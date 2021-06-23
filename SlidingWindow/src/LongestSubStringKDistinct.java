import java.util.HashMap;

/**
 * Problem:
 * Given a String, return the length of the longest substring with K distinct characters
 */

public class LongestSubStringKDistinct {
    public static void main(String[] args) {
        String s = "AAAHHHGGGGG";
        System.out.println(findLength(s, 2));

        String str = "ghijkm";
        System.out.println(findLength(str, str.length()));

        String st = "linhh";
        System.out.println(findLength(st, 2));
    }

    private static int findLength(String s, int k) {
        int length = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int windowStart = 0;

        for (int windowEnd =0; windowEnd<s.length(); windowEnd++) {
            char currChar = s.charAt(windowEnd);
            hashMap.put(currChar, hashMap.getOrDefault(currChar, 0) +1);

            while (hashMap.size() > k) {
                char charToRemove = s.charAt(windowStart);
                hashMap.put(charToRemove, hashMap.get(charToRemove)-1);

                if (hashMap.get(charToRemove) == 0){
                    hashMap.remove(charToRemove);
                }
                windowStart++;
            }

            length = Math.max(length, windowEnd-windowStart+1);
        }
        return length;
    }
}
