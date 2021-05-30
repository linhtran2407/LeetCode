import java.util.ArrayList;

public class VerifyingAnAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        ArrayList<Character> orderMap = new ArrayList<>();
        for (char c: order.toCharArray()){
            orderMap.add(c);
        }

        for (int w=0; w+1<words.length; w++){
            for (int c=0; c<words[w].length(); c++){

                if (c>=words[w+1].length()) {return false;}

                if (words[w].charAt(c) != words[w+1].charAt(c)) {
                    int currWordChar = orderMap.indexOf(words[w].charAt(c));
                    int nextWordChar = orderMap.indexOf(words[w+1].charAt(c));
                    if (currWordChar > nextWordChar) {return false;}
                    else break;
                }

            }

        }

        return true;
    }
}