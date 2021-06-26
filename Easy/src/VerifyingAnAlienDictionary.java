import java.util.ArrayList;

/*
    @author: Linh Tran
    @version: May 30, 2021

    Runtime and usage info:
    Runtime: 1 ms, faster than 44.11% of Java online submissions for Verifying an Alien Dictionary.
    Memory Usage: 39.2 MB, less than 7.43% of Java online submissions for Verifying an Alien Dictionary.
 */
public class VerifyingAnAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        // keep an arraylist of order with larger index indicates later chars
        ArrayList<Character> orderMap = new ArrayList<>();
        for (char c: order.toCharArray()){
            orderMap.add(c);
        }

        // for each char, compare each pair of adjacent words in the String[] words
        for (int w=0; w+1<words.length; w++){
            for (int c=0; c<words[w].length(); c++){
                // c iterates through the prev word
                // then if it exceeds the latter word's length
                // it means there's no mis-ordering but the latter
                // word is longer -> false
                if (c>=words[w+1].length()) {return false;}

                if (words[w].charAt(c) != words[w+1].charAt(c)) {
                    int currWordChar = orderMap.indexOf(words[w].charAt(c));
                    int nextWordChar = orderMap.indexOf(words[w+1].charAt(c));
                    // only true if the index of char in prev word <= index of
                    // char in latter word (right order), else it's false
                    if (currWordChar > nextWordChar) {return false;}
                    else break;
                }

            }

        }

        return true;
    }
}