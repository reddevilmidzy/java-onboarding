package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private int maxAddValue(Integer integerVal) {
        return String.valueOf(integerVal)
                .chars()
                .map(Character::getNumericValue)
                .sum();
    }
}