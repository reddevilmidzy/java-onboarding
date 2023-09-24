package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isValidate(pobi) && isValidate(crong)) {
            return compare(pobi, crong);
        }
        return -1;
    }

    public static boolean isValidate(List<Integer> pages) {
        if (pages.size() != 2) {
            return false;
        }
        if (pages.get(0) % 2 != 1) {
            return false;
        }
        if (pages.get(1) % 2 != 0) {
            return false;
        }
        if (pages.get(1) - pages.get(0) != 1) {
            return false;
        }
        return 1 < pages.get(0) && pages.get(1) < 400;
    }

    public static int compare(List<Integer> pobi, List<Integer> crong) {
        int pobiVal = maxValue(pobi);
        int crongVal = maxValue(crong);

        if (pobiVal > crongVal) {
            return 1;
        } else if (pobiVal < crongVal) {
            return 2;
        }
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