package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder res = new StringBuilder();
        Antonym antonym = new Antonym();
        for (int i = 0; i < word.length(); i++) {
            res.append(antonym.translate(word.charAt(i)));
        }
        return res.toString();
    }
}


class Antonym {

    public static final int MIN_LOWER_CHAR = 97;
    public static final int MAX_LOWER_CHAR = 122;
    public static final int MAX_UPPER_CHAR = 90;
    public static final int MIN_UPPER_CHAR = 65;

    public char translate(char word) {
        if (isUpper(word)) {
            return (char) (25 - (word - MIN_UPPER_CHAR) * 2 + word);
        }
        if (isLower(word)) {
            return (char) (25 - (word - MIN_LOWER_CHAR) * 2 + word);
        }
        return word;
    }

    private boolean isLower(char word) {
        return MIN_LOWER_CHAR <= word && word <= MAX_LOWER_CHAR;
    }

    private boolean isUpper(char word) {
        return MIN_UPPER_CHAR <= word && word <= MAX_UPPER_CHAR;
    }
}