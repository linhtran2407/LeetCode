public class LetterCombinationsOfAPhoneNumber {
    public static void main() {
        List<String> res = letterCombinations("123");

        System.out.println();
    }

    private static List<String> combinations = new ArrayList<>();
    private Map<Character, String> map = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs",
            '8', "tuv", '9', "wxyz");

    public static List<String> letterCombinations(String digits) {
        // back track
        // recursion
        // if stringbuilder == length of digits -> add to result and return
        // pass in the index of the digit being considered
        // loop through all char of the digit
        // append it to a stringbuilder
        // increase the index to move on to the next digit
        // remove the last char in the strinbuilder for backtracking

        // base case
        if (digits.length() == 0) {
            return combinations;
        }

        backtrack(digits, 0, new StringBuilder());
        return combinations;
    }

    private void backtrack(String digits, int index, StringBuilder sb) {
        // base case
        // finish a combination
        if (sb.length() == digits.length()) {
            combinations.add(sb.toString());
            return;
        }

        // all possible characters associated with the current digit
        String characters = map.get(digits.charAt(index));
        for (char c : characters.toCharArray()) {
            sb.append(c);
            backtrack(digits, index + 1, sb);

            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
