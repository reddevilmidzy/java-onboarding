package onboarding;

import java.util.Arrays;
import java.util.HashSet;

public class Problem3 {
    public static int solution(int number) {
        Counter counter = new Counter(new HashSet<>(Arrays.asList('3','6','9')));
        return counter.count(number);
    }
}

class Counter {

    private final HashSet<Character> target;

    public Counter(HashSet<Character> target) {
        this.target = target;
    }

    public int count(int number) {
        int res = 0;
        for (int i = 1; i <= number; i++) {
            res += clap(i);
        }
        return res;
    }

    private int clap(int number) {
        return String.valueOf(number)
                .chars()
                .mapToObj(ch -> (char) ch)
                .filter(target::contains)
                .mapToInt(ch -> 1) // Count each matching character as 1
                .sum();
    }
}