package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public int compare(List<Integer> pobi, List<Integer> crong) {
        int pobiVal = maxValue(pobi);
        int crongVal = maxValue(crong);

        return 0;
    }

    private static int maxValue(List<Integer> pages) {
        return pages.stream()
                .mapToInt(val -> Math.max(maxAddValue(val), maxMulValue(val)))
                .max()
                .orElse(0);
    }

    private static int maxAddValue(Integer integerVal) {
        return String.valueOf(integerVal)
                .chars()
                .map(Character::getNumericValue)
                .sum();
    }

    private static int maxMulValue(Integer integerVal) {
        return String.valueOf(integerVal)
                .chars()
                .map(Character::getNumericValue)
                .reduce(1, (a, b) -> (a * b));
    }
}